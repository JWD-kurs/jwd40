## Lab 6 - SPA, AngularJS

### SPA (Single Page Application)

U SPA, potreban kod - HTML, JavaScript i CSS se ne učitavaju odjednom, već se parcijalno dovlače AJAX pozivima kada su potrebni.
Reload stranica se ne radi ni u kom trenutku, kao ni prebacivanje na neku drugu stranicu ununtar aplikacije - stvara se samo privid
reload-ovanja stranica i navigacije kao ostalim stranicama. Odnosno, dešava se samo logička promena stranica, iako je korisnik sve vreme zapravo na istoj stranici
(otuda naziv Single Page Application).
Interakcija sa SPA uključuje stalnu komunikaciju aplikacije sa (REST) web servisom u pozadini.

1. (SPA and the Single Page Myth)[http://www.johnpapa.net/pageinspa/]
2. (SPA-wiki)[http://en.wikipedia.org/wiki/Single-page_application]

Glavna ideja SPA je da se renderuju i menjaju samo oni elementi korisničkog interfejsa za koje je to potrebno.
Menjanje elemenata korisničkog interfejsa uglavnom podrazumeva intenzivnu manipulaciju HTML-om i DOM-om unutar stranice.

Postoji veliki broj JavaScript biblioteka koje služe za pravljenje SPA (AngularJS, Reactjs, Vuejs...). Na ovom kursu
će biti korišćen AngularJS.

### AngularJS

AngularJS je JavaScript framework za pravljenje klijentskih aplikacija (JS, HTML, CSS). Nastao je u Google, ali je sada open-source projekat.
AngularJS se koristi za pravljenje SPA, pritom se oslanjajući na REST web servise za obavljanje CRUD operacija nad podacima.

Web site - [https://angularjs.org/](https://angularjs.org/).

----

#### Statički resursi

U web aplikacijama, HTML, CSS i JS fajlovi su statički resursi - u smislu da prilikom učitavanja stranice, ovi fajlovi se dobave sa servera i njihova upotreba se vrši u samom browseru.

Spring ima posebne foldere iz kojih servira statičke resurse. Jedna od mogućih varijanti je folder koji se **mora nalaziti u src/main/webapp**. Druga varijanta jeste folder **static folder unutar foldera src/main/resources**.
(pogledati [https://spring.io/blog/2013/12/19/serving-static-web-content-with-spring-boot](https://spring.io/blog/2013/12/19/serving-static-web-content-with-spring-boot)).

---

* U src/main/resources, napraviti folder "static" i u njemu sledeću strukturu:

```
src/main/resources/static
				|
				-- app
					|
					-- html
					|
					-- js
				--assets
					|
					-- js
					-- css
```

* U src/main/resources/static/ napraviti novi fajl - index.html (HTML5) - ovo će biti osnovna stranica naše SPA aplikacije.

* Stranica index.html ima specijalan trentman, jer je, u slučaju kad postoji, Spring smatra početnom stranicom ("welcome page"). To znači da će ona biti servirana kao korenski resurs, sa adrese http://localhost:8080/ u našem slučaju.

---

* U src/main/resources/static/app/js napraviti novi fajl - main.js - ovde će biti pisan sav AngularJS kod koji se koristi u klijentskoj SPA aplikaciji.

* U index.html dodati import angular.js, i main.js.

```html
<script src="/assets/js/angular.js"></script>
<script src="/app/js/main.js"></script>
```

----

### AngularJS aplikacija

* U main.js inicijalizovati AngularJS aplikaciju, nazvaćemo je **wafepaApp**:

```javascript
var wafepaApp = angular.module('wafepaApp', []);
```

* Takođe, u index.html postaviti direktivu ng-app na nivou korenskog HTML elementa:

```html
<html ng-app="wafepaApp">
...
</html>
```

----

### Controller, scope, view

Kontroleri su zaduženi za manipulaciju modelom (podacima sa kojim radimo). Model se prikazuje pomoću HTML-a, odnosno unutar nekog view-a.
Kontroler može primiti parametar $scope, gde $scope predstavlja vezu sa modelom - svi objekti koje se dodaju u $scope predstavljaju model i mogu se prikazati unutar view-a.

![AngularJS controller scope view](http://3.bp.blogspot.com/-Sk3ZHirPZAc/UeJoMGLcrLI/AAAAAAAACwM/y8oGsuDHpTU/s1600/concepts-controller.png)

* Definisati MyController kontroler u main.js (ovaj kontroler ćemo koristiti samo privremeno):

```javascript
wafepaApp.controller('MyController', function($scope) {

});
```

* U index.html napraviti jedan div element u body i postaviti direktivu ng-controller na taj div element:

```html
<div ng-controller="MyController">

</div>
```

---

### Domaći zadaci

* Pročitati (SPA and the Single Page Myth)[http://www.johnpapa.net/pageinspa/]
* Pogledati postojeće angularjs direktive: [https://docs.angularjs.org/api/ng/directive]
* Napraviti malu angularjs aplikaciju, po uzoru na aplikacije iz primera:
  * Napraviti html stranicu i js datoteku; uvući angularjs i js datoteku u html
  * Napraviti modul i kontroler; uvezati sa html-om pomoću direktiva
  * Dodati polje za unos teksta i dugme. Onemogućiti pritisak na dugme ukoliko je polje prazno, u suprotnom pritiskom na dugme obrisati sadržaj polja.
  * Dodati dva polja za unos teksta. Unos u prvo polje preslikava se u drugo polje, ali ne i obrnuto (ako se unese nešto u drugo polje, ne menja se prvo polje)
* Odraditi zadatak dat u folderu "Dokumenti/Back-end zadatak". Rešenje ćemo koristiti na osmom terminu.

