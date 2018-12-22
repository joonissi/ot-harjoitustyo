# Käyttöohje

Lataa tiedosto [opinnot-2.0](https://github.com/joonissi/ot-harjoitustyo/releases/download/2.0/Opinnot-2.0.jar)

## Konfigurointi

Ohjelmaa ei tarvitse tarkemmin konfiguroida ennen käyttöä. Sovellus hoitaa konfiguroinnin käyttäjän puolesta.

## Ohjelman käynnistäminen

Ohjelma suoritetaan komennolla:
```
java -jar opinnot-2.0.jar
```


## Kirjautuminen

Ohjelma käynnistyy ja luo tarvittavat tiedostot käyttäjän kovalevylle. Alkutilassa tietokanta on tyhjä, joten käyttäjä joutuu rekisteröimään itselleen tunnuksen.

Kun käyttäjä on rekisteröinyt käyttäjätunnuksen voi hän kirjautua sillä ja valitsemallaan salasanalla sovelluksen kirjautumisnäkymässä.

## Opintojen merkkaaminen

Käyttäjän ollessaan kirjautuneena voi hän katsella jo lisättyjä opintoja. Myös opintojen muokkaus lisäys ja poistaminen onnistuu helposti.

### Lisäys

Alareunassa on kentät kurssin nimelle, opintopisteille ja merkintä onko kurssi suoritettu vai ei. Käyttäjä lisää edelliset tiedot ja painaa 'Add' -nappia jolloin  
ohjelma päivittää opinnon ohjelmaan.

### Poisto

Käyttäjä näkee listauksessa kaikki lisäämänsä opinnot ja voi poistaa niitä yksitellen 'Delete' -nappia painamalla.

### Muokkaus

Käyttäjä voi muokata kurssia painamalla kurssin kohdalla 'Edit' -nappia jolloin alareunan kenttiin tulee kurssin tiedot mitä voi muokata. Muokkauksen  
valmiiksi saattaminen tapahtuu painamalla 'Edit' -nappia jolloin ohjelma päivittää kurssin.  

## Uloskirjautuminen

Yläreunassa on nappi 'logout' mitä painamalla käyttäjä voi kirjautua ulos sovelluksesta. Tällöin käyttäjä palautuu ohjelman alkunäkymään.
