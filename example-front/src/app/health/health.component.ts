import { Component } from '@angular/core';
import { Health, BuildInfos, HealthService } from '../services/health.service';

@Component({
  selector: 'app-health',
  templateUrl: './health.component.html',
  styleUrls: ['./health.component.scss']
})
export class HealthComponent {

  health: Health;

  constructor(private healthService: HealthService) {
    this.health = {
      build: { name: '', time: '', version: ''}
    }
  }

  ngOnInit() {
    this.healthService.getHealthStatus()
      .subscribe((data:Health) => {
        this.health = data;
    });
  }

}
