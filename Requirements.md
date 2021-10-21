De FriendshipUpdater doet aanpassingen aan een Array van Friends.

Hoe meer interacties een user heeft met een van zijn Friends, 
hoe sterker de vriendschap wordt. 
De sterkte van de vriendschap wordt aangegeven door het aantal sterren.
Hoe meer sterren de vriendschap heeft, hoe meer mogelijke soorten interacties de User kan doen met deze Friend.  

Een nieuwe Friend heeft 0 sterren. 
Vanaf de eerste interactie wordt dit een 1-ster vriendschap.
Bij elke interactie gaat het level van de vriendschap omhoog met 1. 
Een vriendschap wordt 2 sterren bij een level van 10 en 3 sterren bij een level van 30. 
Elke keer als een vriendschap een ster bijkrijgt wordt het level terug op 0 gezet. 

Een Friend heeft:
* name: naam van de Friend 
* nrOfStars: aantal sterren dat deze vriendschap heeft (maximum 3)
* friendshipLevel: het level 
* isLucky: boolean 
* didSomeInteractionToday: is er vandaag interactie geweest met deze Friend 

Bij een Lucky Friend gaat het level 5 keer zo snel omhoog. 
Je kan alleen Lucky Friend worden als je een 3 sterren vriendschap hebt met deze Friend. Het level moet dan ook minstens 60 zijn.

Let op: je wordt niet automatisch Lucky Friend, maar pas vanaf dit moment heb je **kans** dat de parameter isLucky true wordt. Die kans is random en behoort niet tot de update-functie.

Zodra er een interaction met een Lucky Friend geweest is dan is de Friendship niet meer Lucky. 

Een volledige test set is voorzien voor deze code. 
Als je zelf nog missing testen vindt mag je deze toevoegen. 
Je mag alles aanpassen behalve 
* de signature van de update() functie in class FriendshipUpdater 
* de class Friend 
