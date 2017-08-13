import {DecathlonService} from "../components/decathlon-service";
import {autoinject} from "aurelia-dependency-injection";
import * as _ from "underscore";

@autoinject
export class Decathlon {

  constructor(private decathlonService: DecathlonService) {}

  public events: DecathlonEvent[] = [];
  public calculationDirection: boolean = true;
  public total: number = 0;

  private eventElements:Map<DecathlonEventType, Array<string>> = new Map(
    [[DecathlonEventType.EVENT_100M, ["100m","s"]],
     [DecathlonEventType.EVENT_LONG_JUMP, ["Long jump","cm"]],
     [DecathlonEventType.EVENT_SHOT_PUT, ["Shot put","m"]],
     [DecathlonEventType.EVENT_HIGH_JUMP, ["High jump","cm"]],
     [DecathlonEventType.EVENT_400M, ["400m","s"]],
     [DecathlonEventType.EVENT_110M_HURDLES, ["110m hurdles","s"]],
     [DecathlonEventType.EVENT_DISCUS_THROW, ["Discus throw","m"]],
     [DecathlonEventType.EVENT_POLE_VAULT, ["Pole vault","cm"]],
     [DecathlonEventType.EVENT_JAVELIN_THROW, ["Javelin throw","m"]],
     [DecathlonEventType.EVENT_1500M, ["1500m","s"]],
    ]);

  attached() {
    this.initEvents();
  }

  private initEvents() {

    for (let eventType in DecathlonEventType) {

      this.events.push(this.getNewEvent(DecathlonEventType[eventType.valueOf()]) );

    }

  }



  private getNewEvent(type: DecathlonEventType): DecathlonEvent {
    return {
      title: this.eventElements.get(type)[0],
      type: type,
      result: "",
      points: 0,
      unit: this.eventElements.get(type)[1]
    };
  }

  private getDirection(): CalculationDirection {

    return this.calculationDirection ? CalculationDirection.POINTS : CalculationDirection.RESULTS

  }

  public switchDirection(direction: boolean) {
    this.calculationDirection = direction
  }


  public calculateTotal() {
    this.total=0;
    _.forEach(this.events, (event) => {
      if (typeof event.points == 'number')
        this.total = this.total + event.points;
      else
        this.total = this.total + parseInt(event.points)
    });

  }

  public clearValues() {
    _.forEach(this.events, (event) => {
      event.result="";
      event.points=0
    });
    this.total=0
  }

  public calculate(event: DecathlonEvent) {

    if (this.getDirection() == CalculationDirection.POINTS) {
      this.decathlonService.calculate(event.type, event.result, CalculationDirection.RESULTS).then(result => {
        event.points = parseInt(result);
        this.calculateTotal();
      });
    }

    if (this.getDirection() == CalculationDirection.RESULTS) {
      this.decathlonService.calculate(event.type, event.points.toString(), CalculationDirection.POINTS).then(result => {
        event.result = parseFloat(result).toFixed(2);
        this.calculateTotal();
      });
    }

  }

}

export enum CalculationDirection {
  POINTS = <any>'POINTS',
  RESULTS = <any>'RESULTS'
}


export enum DecathlonEventType {
  EVENT_100M = <any>'EVENT_100M',
  EVENT_LONG_JUMP = <any>'EVENT_LONG_JUMP',
  EVENT_SHOT_PUT = <any>'EVENT_SHOT_PUT',
  EVENT_HIGH_JUMP = <any>'EVENT_HIGH_JUMP',
  EVENT_400M = <any>'EVENT_400M',
  EVENT_110M_HURDLES = <any>'EVENT_110M_HURDLES',
  EVENT_DISCUS_THROW = <any>'EVENT_DISCUS_THROW',
  EVENT_POLE_VAULT = <any>'EVENT_POLE_VAULT',
  EVENT_JAVELIN_THROW = <any>'EVENT_JAVELIN_THROW',
  EVENT_1500M = <any>'EVENT_1500M'
}

export interface DecathlonEvent {
  title: string,
  type: DecathlonEventType;
  result: string;
  points: number;
  unit: string;
}
