### 6大设计原则 
* 单一职责原则（_Single Responsibility Principle，SRP_）  
* 里氏替换原则（_Liskov Substitution Principle，LSP_）  
* 依赖倒置原则（_Dependence Inversion Principle，DIP_）  
* 接口隔离原则（_Interface Segregation Principle，ISP_）  
* 迪米特法则（_Law of Demeter，LoD_）/最少知识原则（_Least Knowledge Principle，LKP_）  
* 开闭原则（_Open Closed Principle，OCP_）  

---

### 设计模式(Design patterns)  

#### 1. 创建型模式(Creational patterns)     
    创建型模式提供了创建对象的机制， 能够提升已有代码的灵活性和可复用性。  

##### 1.1 工厂方法模式(Factory Method)  
    工厂方法模式是一种创建型设计模式， 其在父类中提供一个创建对象的方法， 允许子类决定实例化对象的类型。

##### 1.2 抽象工厂模式(Abstract Factory)  
    抽象工厂模式是一种创建型设计模式， 它能创建一系列相关的对象， 而无需指定其具体类。

##### 1.3 生成器模式(Builder)  
    生成器模式是一种创建型设计模式， 使你能够分步骤创建复杂对象。 该模式允许你使用相同的创建代码生成不同类型和形式的对象。

##### 1.4 原型模式(Prototype)  
    原型模式是一种创建型设计模式， 使你能够复制已有对象， 而又无需使代码依赖它们所属的类。

##### 1.5 单例模式(Singleton)  
    单例模式是一种创建型设计模式， 让你能够保证一个类只有一个实例， 并提供一个访问该实例的全局节点。

#### 2. 结构型模式(Structural patterns)  
    结构型模式介绍如何将对象和类组装成较大的结构， 并同时保持结构的灵活和高效。
    
##### 2.1 适配器模式(Adapter)  
    适配器模式是一种结构型设计模式， 它能使接口不兼容的对象能够相互合作。

#### 3. 行为模式(Behavioral patterns)  
    行为模式负责对象间的高效沟通和职责委派。
  
  
[参考资料](https://refactoringguru.cn/design-patterns)
