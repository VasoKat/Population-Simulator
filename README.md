# Population-Simulator
Population Simulator is a program simulating the evolution of a population of rabbits and foxes in Java.
Animals are confined within a 2D grid of cells dimension 20×20. Only one animal can be in a cell any time.
Animals can only move between neighboring cells (up, down, right, left) and can not go out of the grid.
The simulation time flows in discrete steps. Every animal makes some actions at every step.
Specifically, rabbits do the following actions:
• Movement: At each step a rabbit randomly chooses one of the neighboring cells. If the cell is inside the
grid and is not occupied,the rabbit moves to this cell. Otherwise it stays in the cell which is already.
• Reproduction: If the rabbit survives for three steps, at the end of the third step it tries to
reproduce. This is simulated by creating a new rabbit in a neighboring cell which is empty. If there is no
empty neighboring cell, then the rabbit does not breed. If it passes the breeding step
(either successfully or not), the next attempt is after three more steps.
Foxes do the following actions:
• Move: At each step, if there is a neighboring cell containing a rabbit, the fox
moves to that cell and eats the rabbit. Otherwise it moves in the same way as the rabbit. 
A fox cannot eat another fox.
• Breeding: Breeding is done in exactly the same way as is done in rabbits, but every eight
steps instead of every three.
• Death by starvation: If the fox does not eat a rabbit for three steps then it dies due to starvation.
In the simulation the foxes will act first and then the rabbits.
