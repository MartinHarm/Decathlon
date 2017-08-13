import {HttpClient} from "aurelia-fetch-client";
import {CalculationDirection, DecathlonEventType} from "src/pages/decathlon";
import {autoinject} from "aurelia-dependency-injection";

@autoinject
export class DecathlonService {

  public calculate(event:DecathlonEventType, result: string, direction: CalculationDirection):Promise<string> {

    let httpClient = new HttpClient();

    return httpClient.fetch(`${direction}/calculator?event=${event}&value=${result}`)
      .then(result => {
        return result.json()
      });

  }

}
