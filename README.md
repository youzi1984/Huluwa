# 葫芦娃大战妖精

**郭雨琦 151220035**


## 实现效果

1. 按下`空格键`之后，正方按`鹤翼`阵型出发；反方以`长蛇`阵型出发；
2. 打斗开始前或者打斗结束后按下`L`可实现读取文件并回放；
3. 回放和打斗过程中按下`P`可暂停；
4. 游戏目标：击败所有敌人


## 游戏界面

进入游戏后界面如下

<img src="screenshoots/初始.png" width="600">

按下`空格键`后，正方按`冲轭阵`出发；反方以`鹤翼阵`出发

<img src="screenshoots/战斗.png" width="600">

战斗开始前或结束后，可以按‘L’打开文件夹，选择存档，重现场景

<img src="screenshoots/文件.png" width="600">



## 战斗设定

* 葫芦娃的奔跑速度是其他所有生物的两倍。

* 当正反双方相遇时，由上帝决定双方的生死，正方有八成的概率获胜。



## 精彩的战斗

在save文件夹中，存放了几次精彩的战斗场景。




## 封装与继承

`Player`类实现了`Runnable`接口，葫芦娃，爷爷，蝎子精，蛇精，小啰啰均继承自Player。



## 多态

`Field`类中的3个`ArrayList`均使用泛型实现，体现了多态：

```java
public ArrayList<Player> positiveCreatures;
public ArrayList<Player> negativeCreatures;
public ArrayList<Huluwa> brothers;
public ArrayList<Lackey> lackeys;
```



## 设计原则

### 单一职责原则

* `Main`类只负责建立`Ground`类和`BackEnd`类


* `Ground`类只负责游戏画面显示
* `BackEnd`类只负责游戏的逻辑
* `Creatures`类（包括其子类）只负责角色的定义
* `ConstantValue`接口只负责提供全局常量
* `FileFilterTest`类只负责过滤类型为".fight"的文件
* `FileOperation`类只负责文件读写

### 里氏替换原则

所有的*Creatures*都能被*Good*或者*Bad*替换；所有的*Good*都能被**Grandpa**或者**GourdDolls**替换；所有的*Bad*都能被**ScorpionKing**、**SnakeQueen**或者**Toad**替换。

### 开放封闭原则

`Grandpa`与`GourdDolls`同为`Good`的子类，但是之所以不直接用`Good`类，是因为`GourdDolls`类还有一个独有的域`id`以标志不同葫芦娃，这体现了**一个类应该对扩展开放**的原则。



## 集合与泛型

程序中用到的集合是`ArrayList`，其中主要是`ArrayList<Good>`、`ArrayList<Bad>`和`ArrayList<Creatures>`，分别用于存储正方(`GoodCreatures`)、反方(`BacCreatures`)与死亡的正反方(`DeadCreatures`)。

之所以用集合而不是数组，是因为每个时钟周期的检查中，会将`GoodCreatures`和`BadCreatures`中已经死亡的角色移动到`DeadCreatures`中，而数组无法添加删除元素。



## 注解

用`@Override`和`@Test`注解。



## 输入输出

`FileOperation`类中采用的输入输出类有

* `File`：用于获取文件
* `FileReader`与`BufferedReader`：用于读取文件
* `FileWriter`与`BufferedWriter`：用户写入文件





## 单元测试

* 对角色的测试有3个测试方法`testString`、`testLocation`和`testImage()`，分别测试`toString()`、`getX()`、`getY()`、`setX()`、`setY()`、`getImage()`、`setImage()`等方法的正确性。

