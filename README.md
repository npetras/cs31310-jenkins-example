# CS31310 Jenkins Example

This project uses the example code from the end of the Refactoring video, from week 4.

In this workshop, you will modify the Maven file. At the relevant points of the worksheet, you can copy extracts from this file into the Maven file. 

## Adding JaCoCo dependency

Add the following into the `dependencies` section of the `pom.xml` file.

```
        <dependency>
            <groupId>org.jacoco</groupId>
            <artifactId>org.jacoco.agent</artifactId>
            <classifier>runtime</classifier>
            <version>0.8.6</version>
            <scope>test</scope>
        </dependency>

```

## Setting up JaCoCo

Add the following into the `plugins` section of the `pom.xml` file.

```
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.2</version>
                <executions>
                    <execution>
                        <id>prepare-agent</id>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>default-report</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>default-check</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>check</goal>
                        </goals>
                        <configuration>
                            <rules>
                                <rule>
                                    <element>BUNDLE</element>
                                    <limits>
                                        <limit>
                                            <counter>COMPLEXITY</counter>
                                            <value>COVEREDRATIO</value>
                                            <minimum>0.30</minimum>
                                        </limit>
                                    </limits>
                                </rule>
                            </rules>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
```
