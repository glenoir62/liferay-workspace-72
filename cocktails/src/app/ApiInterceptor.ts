import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';

@Injectable()
export class ApiInterceptor implements HttpInterceptor {
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // Apply the headers
        req = req.clone({
            setHeaders: {
                'Authorization': 'Basic dGVzdEBsaWZlcmF5LmNvbTp0ZXN0',
            }
        });

        // Also handle errors globally
        return next.handle(req).pipe(
            tap(x => x, err => {
                // Handle this err
                console.error(`Error performing request, status code = ${err.status}`);
            })
        );
    }
}