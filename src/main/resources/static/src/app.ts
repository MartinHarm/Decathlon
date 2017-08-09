import {Router, RouterConfiguration} from 'aurelia-router';

export class App {
  public router: Router;

  public configureRouter(config: RouterConfiguration, router: Router) {
    config.title = 'Decathlon';
    config.map([
      { route: ['', 'decathlon'], name: 'decathlon',      moduleId: 'decathlon',      nav: true, title: 'Decathlon' }
    ]);

    this.router = router;
  }
}
