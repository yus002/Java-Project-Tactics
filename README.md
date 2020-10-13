Yue Sun
cs8bwadc
yus002@ucsd.edu
2/20/19

1. public: accesible by any Java code
private: access is permitted only in code within the class
the member is declared in 
protected: access is permitted 1) from within the same package
and 2) from within a subclass of the class in which it is declared
default: access is permitted only from within the same package.

2. When two class has similar characteristics, inheritance provides
convenience for writting methods since some
methods do not need to be written again, and they are inherited.
For methods act differently, just override.

3. Animal objects have already extended from Critter. They cannot extend from Movable 
while â€œimplementâ€ enables them to inherit from multiple sources 
such as Critter and Movable. 
Interface also determines the certain pattern of the class.

4. No, we can not because Starfish is not a subclass
of Movable. There is no is-a relationship.

5. toString() is included in Object class and Starfish class
is instanceof Object class.

6. It would be inherited from class Feline. It will always
pounce.

7. Turtle's attack pattern is slightly different from the 
initialized attack pattern which is always forfeit. Turtle
at least roar at 50% chance during the combat.

8. They are inheriting from interface Movable. Starfish is 
supposed to not move at all so it is not overriding getMove().

9. They do not rely on objects, so invoking them is convenient.
The helper method generateAttack() is a static method. I use
it directly to return a random attack.

10. The critter searches for food and move towards it.
It always pounce when encountering a different species.
It will go in a random direction if there is no food nearby.
