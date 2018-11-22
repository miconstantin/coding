# Backend Coding Challenge: Mapping Challenge

acceptance criteria: 
 - `Article` is correctly mapped to `ArticleDTO` (see `ArticleController#list` and `ArticleController#details`) and is emitted as a JSON from the Controllers
 - the collection of `ArticleBlockDto` in `ArticleDTO` is sorted after `sortIndex` in `ArticleBlockDTO`
 - in case an `Article` cannot be found via ID, a 404 shall be shown (see `ArticleController#details`)
 - optional: in case a new implementation of `ArticleBlock` is created and no mapping is implemented, the user shall get an info
 
general conditions:
 - DB Models and DTO Models can be extended with Interfaces/Properties
 - Existing field of Models and DTOs shall not be modified
 - the Package structure shall not be modified
 - Any other gradle dependencies can be added.
 
Notes:
  	Updated `ArticleRepository`:
  	    - to return existing article 1001-5005 instead of a new one each time
  	    - to return an `Image` instead of null (assuming haste in original implementation)
  	    - and corrected index order for `ArticleBlockDto` (assume it was meant with different indexes)
  	Used FQDN as some consider acceptable. I would rather go with different DTO names for readability. Matter of agreed project standard
  	I used Swagger and acceptance criteria can be tested by firing the application and navigating to http://localhost:8100/swagger-ui.html
  	Added a new `ArticleBlock` type called `AudioBlock` with minimal features. Now I can even force a DTO implementation at visitor level
  	Minor typo fixes
  	Added minimal unit/integration tests; more can be done to increase coverage/cases but for the time being will suffice



--- German -----------------------------------------------

Akzeptanzkritieren: 
 - `Article` wird korrekt zu `ArticleDTO` gemapped (Siehe `ArticleController#list` und `ArticleController#details`) und als JSON von den Controllern ausgegeben. 
 - Die Collection von `ArticleBlockDto` in `ArticleDTO` ist nach dem `sortIndex` in `ArticleBlockDTO` sortiert
 - Falls ein `Article` per ID nicht gefunden werden kann, soll eine 404 Repsonse ausgeliefert werden (Siehe `ArticleController#details`)
 - Optional: Falls eine neue Implementierung/Ableitung von `ArticleBlock` implementiert wird und noch kein Mapping implementiert ist,
   soll mann darauf hingewiesen werden. Wie ist frei überlassen.
 
Rahmenbedingungen:
 - DB Models und DTO Models können mit Interfaces/Properties erweitert werden.
 - Bestehende Felder von Models und DTOs können nicht modifiziert werden. 
 - Die Packagestruktur darf nicht modifiziert werden. 
 - Es können beliebig gradle dependencies hinzugefügt werden. 
