import { Injectable } from '@angular/core';
import { environment } from "../environments/environment";
import { HttpClient } from '@angular/common/http';
import { DataResource } from './data-resource';
import { Attraction } from './Attraction';
import { map, take } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { City } from './city';

@Injectable({
  providedIn: 'root'
})
export class InfoService {

  private BASE_URL: string

  constructor(private http: HttpClient) { 
    this.BASE_URL = `${environment.baseUrl}/info`
  }

  test() {
    console.log(this.BASE_URL)
  }

  getTopAttractions() : Observable<Attraction[]> {
    return this.http.get<DataResource<Attraction>>(`${this.BASE_URL}/touristLocations`, {
      params: {
        "page": "1",
        "size": "4"
      }
    }).pipe(map(r => r._embedded['touristLocations']))
    .pipe(map(locs => {
      for (const loc of locs) {
        let arr = loc._links.self.href.split("touristLocations/")
        loc.locationId = parseInt(arr[1])
      }
      return locs
    }))
  }

  getTopCities(): Observable<City[]> {
    return this.getPaginatedCities(0, 4)
  }

  getAllCities(): Observable<City[]> {
    return this.getPaginatedCities(0, 1000  )
  }

  getCityDetail(cityId): Observable<City> {
    return this.http.get<City>(`${this.BASE_URL}/cities/${cityId}`)
    .pipe(map(city => {
      city.id = cityId
      return city
    }))
  }

  getCityAttractions(cityId): Observable<Attraction[]> {
    return this.http.get<Attraction[]>(`${this.BASE_URL}/touristLocations/locationsByCityId`, {
      params: {
        cityId
      }
    })
  }

  getPaginatedCities(pageNumber:number, pageSize:number) {
    return this.http.get<DataResource<City>>(`${this.BASE_URL}/cities`, {
      params: {
        "page": `${pageNumber}`,
        "size": `${pageSize}`
      }
    })
    .pipe(map(
      r => {
        let cities = r._embedded['cities']
        for (const city of cities) {
          let arr = city._links.self.href.split("cities/")
          city.id = arr[1]
        }
        return r
      }
    )).pipe(map(r => r._embedded['cities']))
  }

  getAllAttractions() {
    return this.http.get<Attraction[]>(`${this.BASE_URL}/touristLocations/all`)
  }

  getAttractionById(locationId: any) {
    return this.http.get<Attraction>(`${this.BASE_URL}/touristLocations/${locationId}`)
  }
}
