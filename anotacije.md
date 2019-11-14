# Anotacije korišćene u Spring aplikaciji

## JPA

[@Entity](https://docs.oracle.com/javaee/7/api/javax/persistence/Entity.html)

Označava da je klasa JPA entitet.

[@Table](https://docs.oracle.com/javaee/7/api/javax/persistence/Table.html)

Označava da će se klasa mapirati na tabelu i omogućava da se postave dodatni parametri mapiranja, kao što je ime tabele.

[@Column](https://docs.oracle.com/javaee/7/api/javax/persistence/Column.html)

Omogućava da se specificiraju dodatni parametri mapiranja polja klase na kolonu tabele: ime kolone, da li je kolona nullable, length, precision, ...

[@GeneratedValue](https://docs.oracle.com/javaee/7/api/javax/persistence/GeneratedValue.html)

Označava da će vredost biti automatski generisana. Podrazumevano ponašanje je da će raditi kao običan Autoincrement.

[@Id](https://docs.oracle.com/javaee/7/api/javax/persistence/Id.html)

Označava da će kolona na koju se mapira polje biti pirmarni ključ u bazi.

[@OneToMany](https://docs.oracle.com/javaee/7/api/javax/persistence/OneToMany.html)

Označava da je jedan objekat ove klase u vezi sa više objekata druge klase.

[@ManyToOne](https://docs.oracle.com/javaee/7/api/javax/persistence/ManyToOne.html)

Označava da je više objekata ove klase u vezi sa jednim objektom ove klase.

## Spring 


[@Controller](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Controller.html)

Označava da je klasa Spring kontroler. Kontroler je ujedno @Component

[@RestController](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)

Označava da je klasa Spring RestController komponenta (metode vraćaju ResponseEntity umesto string). RestController je ujedno @Controller, koji je ujedno @Component

[@Service](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Service.html)

Označava da je klasa Spring servis komponenta. Servis je ujedno @Component.

[@Repository](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Repository.html)

Označava da je klasa Spring repozitorijum komponenta.

[@Query](https://spring.io/blog/2014/07/15/spel-support-in-spring-data-jpa-query-definitions)

Omogućava da se specificira JPQL upit kojim će biti implementirana metoda repozitorijuma.

[@Param]

Omogućava da se imenovani parametar JPQL upita ("WHERE a.name=:name") popuni vrednošću koja je došla kao parametar poziva metode repozitorijuma.

[@Component](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Component.html)

Označava da je klasa naša custom Spring komponenta, što znači da će moći da je instancira Spring Dependancy Injection (@Autowired)

[@Autowired](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html)

Omogućava dobavljanje instance neke komponente (kontrolera, servisa, repozitorijuma ili naše komponente) - Dependancy Injection.

Omogućava upravljanje transakcijama, što je neophodno za metode koje modifikuju stanje entiteta.

[@RequestMapping](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html)

Omogućava da se kontroler i metoda kontrolera mapira na određeni URI/URL. 

[@PathVariable](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/PathVariable.html)

Omogućava da pokupimo vrednost dela URL-a (/{id})

[@RequestParam](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html)

Omogućava da pokupimo vrednost URL parametara (?name=Running)

[@RequestBody](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestBody.html)

Omogućava da pročitamo objekat koji je došao u telu HTTP zahteva. 

## Validacija

https://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html
http://docs.jboss.org/ejb3/app-server/HibernateAnnotations/api/org/hibernate/validator/package-summary.html
