export class Decathlon {

  public calculationDirection: boolean = true;

  private getDirection(): CalculationDirection {

    return this.calculationDirection ? CalculationDirection.POINTS : CalculationDirection.RESULTS

  }

  public switchDirection(direction: boolean) {

    this.calculationDirection = direction

  }

}

export enum CalculationDirection {
  POINTS = <any>'POINTS',
  RESULTS = <any>'RESULTS'
}
