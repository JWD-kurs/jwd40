## Lab 8 - Bootstrap, Forme


### Rukovanje vezama

Entitet Record je vezan many-to-one vezom sa entitetima User i Activity. Stoga, potrebno je obezbediti sledeće stavke (kostur rešenja je dat):

* Prikaz imena korisnika i imena aktivnosti prilikom prikaza beleške.
* Odabir korisnika i aktivnost prilikom kreiranja nove beleške.
* Izmena prethodno prikazanih vrednosti za vezanog korisnika i aktivnost.

Kako bi se prilikom izmene prikazale odabrane opcije u selekciji, iskoristićemo direktivu ng-selected. Primer:

```html
<select class="form-control" ng-model="record.userId">
	<option ng-repeat="u in users" value="{{u.id}}" ng-selected="u.id == record.userId">{{u.firstname}}</option>
</select>
```

Međutim! Ako ne pazimo na redosled kojim se dobavljaju podaci, postoji mogućnost da ng-selected ne može da odradi posao (u ovom slučaju, moramo obezbediti da korisnici stignu pre beleške)! 

----

### Bootstrap

Bootstrap predstavlja biblioteku CSS (CSS3) klasa, kao i pomoćnih JavaScript funkcija.
Kompatibilan je isključivo sa HTML5 dokumentima. Baziran je na tzv. "responsive design" principu,
i omogućava lako prilagođavanje web aplikacije mobilnim uređajima (tablet, smartphone, ...).

Veoma je dobro dokumentovan, sa velikim brojem primera korišćenja. Bootstrap se može preuzeti na ovom [http://getbootstrap.com/](http://getbootstrap.com/).

----

* Downloadovati Bootstrap CSS i importovati u projekat.

* Iskoristiti neki od Bootstrap primera kao šablon za WAFEPA web aplikaciju. Primeri na [https://getbootstrap.com/docs/4.0/examples/](https://getbootstrap.com/docs/4.0/examples/).

* Iskoristiti Bootstrap stilove za tabele na stranici za prikaz aktivnosti.

* Iskoristiti Bootstrap stilove za forme na stranici za prikaz dodavanje/izmenu aktivnosti.


### Domaći zadatak

1. Eksperimentisati sa Bootstrap CSS i komponentama
2. Pogledati alternativu za Bootstrap, a to je Material design (by Google) - [http://materializecss.com/](http://materializecss.com/)
3. Napraviti da je alert sa porukom greške na stranici za prikaz aktivnosti "dissmissable", tj. da može da se ugasi.
4. Na stranici za prikaz svih aktivnosti pored naslova stranica ispisati ukupan broj aktivnosti (iskoristiti Bootstrap badges).
5. Pogledati promise chaining, kojim se može obezbediti redosled izvršavanja asinhronih poziva: [https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/then#Chaining](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/then#Chaining)
6. Izmeniti back-end tako da se podrži pretraga beleški (Records) po imenu aktivnosti, minimalnoj dužini trajanja i intenzitetu. Pronalaze se i prikazuju beleške koje zadovoljavaju sve kriterijume. Ukoliko korisnik neko polje ne unese, vrednost tog polja se ignoriše u pretrazi.
7. Razdvojiti svaki od angular komponenti u zaseban fajl!

