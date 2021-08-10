# Project Lawn Mover

## Version FR
La société MowItNow a décidé de développer une tondeuse à gazon automatique, destinée aux surfaces rectangulaires.

La tondeuse peut être programmée pour parcourir l'intégralité de la surface.

La position de la tondeuse est représentée par une combinaison de coordonnées (x,y) et d'une lettre indiquant l'orientation selon la notation cardinale anglaise (N,E,W,S). La pelouse est divisée en grille pour simplifier la navigation. 

Par exemple, la position de la tondeuse peut être « 0, 0, N », ce qui signifie qu'elle se situe dans le coin inférieur gauche de la pelouse, et orientée vers le Nord.

Pour contrôler la tondeuse, on lui envoie une séquence simple de lettres. Les lettres possibles sont « D », « G » et « A ». « D » et « G » font pivoter la tondeuse de 90° à droite ou à gauche respectivement, sans la déplacer. « A » signifie que l'on avance la tondeuse d'une case dans la direction à laquelle elle fait face, et sans modifier son orientation.

Si la position après mouvement est en dehors de la pelouse, la tondeuse ne bouge pas, conserve son orientation et traite la commande suivante. 

On assume que la case directement au Nord de la position (x, y) a pour coordonnées (x, y+1).

Pour programmer la tondeuse, on lui fournit un fichier d'entrée construit comme suit :
* La première ligne correspond aux coordonnées du coin supérieur droit de la pelouse, celles du coin inférieur gauche sont supposées être (0,0)
* La suite du fichier permet de piloter toutes les tondeuses qui ont été déployées. Chaque tondeuse a deux lignes la concernant :
* la première ligne donne la position initiale de la tondeuse, ainsi que son orientation. La position et l'orientation sont fournies sous la forme de 2 chiffres et une lettre, séparés par un espace
* la seconde ligne est une série d'instructions ordonnant à la tondeuse d'explorer la pelouse. Les instructions sont une suite de caractères sans espaces.

Chaque tondeuse se déplace de façon séquentielle, ce qui signifie que la seconde tondeuse ne bouge que lorsque la première a exécuté intégralement sa série d'instructions.

Lorsqu'une tondeuse achève une série d'instruction, elle communique sa position et son orientation.

###OBJECTIF
Concevoir et écrire un programme s'exécutant sur une JVM ≥ 1.7, un navigateur web ou un serveur node.js, et implémentant la spécification ci-dessus et passant le test ci-après

### TEST
Le fichier suivant est fourni en entrée :

`5 5`

`1 2 N`

`GAGAGAGAA`

`3 3 E`

`AADAADADDA`

On attend le résultat suivant (position finale des tondeuses) :

`1 3 N`

`5 1 E`

> NB: Les données en entrée peuvent être injectée sous une autre forme qu'un fichier (par exemple un test automatisé).




## Version EN
The company MowItNow decided to develop an automatic lawn mower, intended for rectangular areas.

The mower can be programmed to cover the entire area.

The position of the mower is represented by a combination of coordinates (x, y) and a letter indicating the orientation according to the English cardinal notation (N, E, W, S). The lawn is divided into a grid to simplify navigation.

For example, the mower position might be "0, 0, N", which means it is in the lower left corner of the lawn, and facing north.

To control the mower, it is sent a simple sequence of letters. The possible letters are "D", "G" and "A". “D” and “G” rotate the mower 90 ° to the right or left respectively, without moving it. "A" means that the mower is moved forward one space in the direction it faces, and without changing its orientation.

If the post-motion position is off the lawn, the mower does not move, maintains its orientation, and processes the next command.

We assume that the box directly north of the position (x, y) has for coordinates (x, y + 1). 

###OBJECTIVE
Design and write a program running on a JVM ≥ 1.7, a web browser or a node.js server, and implementing the above specification and passing the following test

### TEST
The following file is provided as input: 

`5 5`

`1 2 N`

`GAGAGAGAA`

`3 3 E`

`AADAADADDA`

We expect the following result (final position of the mowers): 

`1 3 N`

`5 1 E`


## Version CN
MowItNow 公司决定开发一种用于矩形区域的自动割草机。

可以对割草机进行编程以覆盖整个区域。

割草机的位置由坐标 (x, y) 和根据英文基本符号 (N, E, W, S) 指示方向的字母组合表示。草坪被划分为网格以简化导航。

例如，割草机的位置可能是“0, 0, N”，这意味着它在草坪的左下角，面向北方。

为了控制割草机，它被发送了一个简单的字母序列。可能的字母是“D”、“G”和“A”。 “D”和“G”分别将割草机向右或向左旋转 90°，无需移动。 “A”表示割草机沿其面向的方向向前移动一个空间，并且不改变其方向。

如果运动后位置离开草坪，割草机不会移动，保持其方向，并处理下一个命令。

我们假设位置 (x, y) 正北的框具有坐标 (x, y + 1)。

###目标
设计并编写运行在 JVM ≥ 1.7、Web 浏览器或 node.js 服务器上的程序，并实现上述规范并通过以下测试

###测试
以下文件作为输入提供：

`5 5`

`1 2 N`

`GAGAGAGAA`

`3 3 E`

`AADAADADDA`


我们期待以下结果（割草机的最终位置）： 

`1 3 N`

`5 1 E`
