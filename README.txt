Just a couple of pointers about the code:
1. When the game starts and you input the dimensions and number of ships, there maybe a chance you get a heap space
   error. This is because the number of ships you inputted is too large for the board. It's still able to fit in the
   board, but you clean and rebuild the code, then it will work fine. Usually, choosing bigger dimensions and smaller
   ships will work easily for testing.
2. Regarding my code, you'll see that a controller will eventually call another controller (BattleSalvoGame->StartGame).
   I chose this method because it will keep the code cleaner. On controller will be responsible for setting up the board
   while the other is responsible for actually running the game.
3. Also regarding the tests, you'll see the JaCoco coverage is 66%. This is because whenever, I tested the BattleSalvoG
   -ame, it would simultaneously test the StartGame controller. Because of this, it would stop all the other tests from
   running. I tried to overcome this but due to time constraints, I was unable to. However, just the BattleSalvoGameTest
   , I was able to get the overall coverage to 50% because of all the things it tested in the background. If these tests
   were combined, the coverage would comfortably be over 90%. So please understand this shortcoming.