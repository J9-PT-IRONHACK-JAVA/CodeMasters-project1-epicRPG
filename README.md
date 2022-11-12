# CodeMasters - epicRPG

![image](https://user-images.githubusercontent.com/86268267/201467558-7bfb6e5d-cb0d-4ce4-a2da-846be7bd9f94.png)<br /><br /><br /><br />

# Jugabilidad
`java -jar epicRPG.jar` para poder ejecutar el juego.<br /><br />
Al ejecutar el juego, aparece la pantalla principal y acto seguido el menu de selección.<br />
Entre todas esas opcion, se encuentran varias formas de creacion de personajes.<br />
![Screenshot 2022-11-12 at 10 25 24](https://user-images.githubusercontent.com/86268267/201467819-ae2c5100-deea-4ce2-ad01-59213ea44499.png)<br />


### Create manual characters
Debes escoger cuantos personajes vas a querer por equipo, con un maximo de 10 y decir que tipo de clase será cada uno.<br />
Esta opcion te permite la maxima personalización de tus personajes, siempre dentro de unos parametros.

### Choose between 3 random characters
Tu escoges cuantos personajes quieres por equipo, y si cada uno será Warrior o Wizard.<br />
El mismo juego te dará a escoger entre 3 personajes distintos con diferentes estadisticas.<br />
Asegurate de escoger bien!

### Create a random team
Sin duda, el modo mas divertido que hay. Te va a dar un numero random de personajes entre 1 y 10.<br />
Tamposo vas a poder escoger clase, nombres, stats,... asi que, mucha suerte!

### Import CSV
Puedes importar tus dos equipos desde un fichero CSV.<br />
Tiene que ser con la suiguiente estructura `WA o WI, NOMBRE (String), HP (int), MANA o STAMINA (int), INTELL o STRENGTH (int) `<br />
Esta opción es muy util, ya que cada vez que creas un equipo de cualquier forma, te va a crear un fichero CSV por cada equipo.
Si te ha gustado cualquiera de los dos equipos podras reutilizarlo importando el CSV.

### Print the graveyard
Creeme, no vas a querer ver a tus jugadores aparecer por aquí...<br />
Una vez la batalla haya terminado y vuelvas al menú, tendras la opcion de ver por pantalla todos los soldados caídos.

# Batalla!!
Ya tienes los equipos preparados y listos para el combate, ahora viene la acción...<br />
Primero deberás escoger entre hacer la batalla tu mismo o simulada.

### Normal Battle
Vas a escoger uno de los personajes de cada equipo y viendo ronda por ronda como avanza la batalla, hasta el momento que uno de los dos caiga.<br />
Cuando uno de los dos muera, se irá al Graveyard y tendrás la opcion de volvera a escoger un personaje de cada equipo.<br />
Así avanzara el combate hasta que uno de los dos equpos se quede sin personajes disponibles, ahí se sabrá quien es el vencedor!

### Simulated Battle
Tendrás que escoger de cada equipo quieres que peleen, entonces el juego se desarrollará de forma automática hasta que uno de los dos caiga.<br />
Cada vez que un personaje muera, volverás a ecoger un personaje por equipo. Quien será el vencedor!?
