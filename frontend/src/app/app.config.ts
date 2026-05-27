import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),

    // HttpClient wird benötigt, um REST APIs vom Spring Boot Backend aufzurufen
    provideHttpClient(),

    // Wurde durch SSR/SSG beim Erstellen des Angular-Projekts hinzugefügt
    provideClientHydration(withEventReplay())
  ]
};