# CS31310 Jenkins Example

This project uses the example code from the end of the Refactoring workshop. 

In this workshop, you will modify the Maven file. At the relevant points of the worksheet, you can copy extracts from this file into the Maven file. 

## Adding JaCoCo dependency

Add the following into the `dependencies` section of the `pom.xml` file.

```
        <dependency>
            <groupId>org.jacoco</groupId>
            <artifactId>org.jacoco.agent</artifactId>
            <classifier>runtime</classifier>
            <version>0.8.2</version>
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

## Adding sloccount support to Maven file

Part of the exercise asks you to add sloccount. The sloccount binary is already installed on the container. This plugin specifies running the shell script to execute the sloccount program. 

```
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>1.6.0</version>
                <executions>
                    <execution>
                        <id>running-sloccount</id>
                        <phase>compile</phase>
                        <goals>
                            <goal>exec</goal>
                        </goals>
                        <configuration>
                            <executable>bash</executable>
                            <arguments>
                                <argument>sloccount.sh</argument>
                            </arguments>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
```