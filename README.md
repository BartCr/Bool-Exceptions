# Bool-Exceptions
Code Kata voor de Exceptions BOoL sessie

## Ventouris
Toon eerst de probleem code in SS zelf:
* VentourisException
* AbstractServiceBean (advice chain)
  * RollbackAdvice
  * WrapExceptionsAndRefreshIDsAdvice

Toon vereenvoudigde versie:
* MyCoolService: service die werk moet laten doen en de fouten terug geven
  * gebruikt daarvoor de BrokenManager die via locate() opgezocht wordt
* BrokenManager:
  * manager interface zoals er binnen SS nog bestaan
* BrokenManagerBean:
  * zoals in SS: gewoon de impl callen via getImplementation()
  * in createImplementation() wordt Advice chain aangemaakt zoals in SS, maar met maar 1 advice: 
    BreakExceptionsAdvice
* BrokenManagerImpl: 
  * Impl waar niks mis mee is:
    * doSomething(String) method throwed VentourisException
    * doSomething(String, String) method is door een developer gemaakt die slimmer wilde zijn en die 
      throwed een RuntimeException (IllegalArgumentException)     
* MyCoolServiceTest laat zien wat we willen bereiken:
  * Een lijst van werk proberen afhandelen waar mogelijk 'null's inzitten
  * We verwachten een lijst met 1 element terug en er mogen alleen maar 'null''s in het resultaat zitten
  * Run en test werkt
* Nieuwe story waaruit blijkt dat we niet alleen w moeten meegeven aan de broken manager, maar ook nog 
  de string "extra".
  * tof, die method bestaat al, dus MyCoolService aanpassen
  * geen VentourisException meer? effe kijken in de impl
  * VentourisException vervangen door IllegalArgumentException 
  * -> klaar, maar als goeie developer zullen we de testen maar runnen
  * ??? wat is er mis
   
  
## Stack
StackTest faalt op de stack.push()? Dit lijkt niet logisch.
Fix Stack class.

## BankAccount
BankAccount test faalt op het controleren van de balans. Hoe komt het dat deze niet klopt?
Fix bank account class.

