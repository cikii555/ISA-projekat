import { TransfusionCenter } from './../model/transfusionCenter.model';
import { CenterService } from './../services/center.service';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { Component, OnInit, ViewChild } from '@angular/core';
import {MatSort, Sort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-home-page-client',
  templateUrl: './home-page-client.component.html',
  styleUrls: ['./home-page-client.component.css']
})
export class HomePageClientComponent implements OnInit {

  public dataSource = new MatTableDataSource<TransfusionCenter>();
  public centers: TransfusionCenter[] = [];
  displayedColumns: string[] = ['Name','Street and number', 'City', 'Country', 'Discription', 'Average grade', 'Work hours'];
  // @ViewChild('empTbSort') empTbSort = new MatSort();
  @ViewChild(MatSort) sort = new MatSort();
  constructor(private _liveAnnouncer: LiveAnnouncer, private centerService: CenterService) {}

  ngOnInit(): void {
    this.centerService.getCenters().subscribe(res => {
      this.centers = res;
      this.dataSource = new MatTableDataSource(this.centers);

      //this.dataSource.data = this.centers;
    })
    this.dataSource.sort = this.sort;
  }

  /** Announce the change in sort state for assistive technology. */
  announceSortChange(sortState: Sort) {
    // This example uses English messages. If your application supports
    // multiple language, you would internationalize these strings.
    // Furthermore, you can customize the message to add additional
    // details about the values being sorted.
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }

}
