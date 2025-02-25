package com.acme.hexagonal.archi;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.acme.hexagonal")
public class NamingConventionTest {

    @ArchTest
    public static final ArchRule consumer_reside_only_consumer_package = classes()
            .that()
            .haveNameMatching(".*Consumer")
            .should()
            .resideInAPackage("..adapters.in.consumer..")
            .as("Consumer classes should reside in adapters.in.consumer package");

    @ArchTest
    public static final ArchRule mapper_reside_only_mapper_package = classes()
            .that()
            .haveNameMatching(".*Mapper")
            .should()
            .resideInAnyPackage(
                    "..adapters.in.consumer.mapper",
                    "..adapters.in.controller.mapper",
                    "..adapters.out.client.mapper",
                    "..adapters.out.repository.mapper"
            )
            .as("Consumer classes should reside in controller, client, consumer or repository package");

    @ArchTest
    public static final ArchRule message_reside_only_message_package = classes()
            .that()
            .haveNameMatching(".*Message")
            .should()
            .resideInAnyPackage(
                    "..adapters.in.consumer.message"
            )
            .as("Consumer classes should reside in message package");

    @ArchTest
    public static final ArchRule controller_reside_only_controller_package = classes()
            .that()
            .haveNameMatching(".*Controller")
            .should()
            .resideInAnyPackage(
                    "..adapters.in.controller"
            )
            .as("Consumer classes should reside in controller package");

    @ArchTest
    public static final ArchRule request_reside_only_request_package = classes()
            .that()
            .haveNameMatching(".*Request")
            .should()
            .resideInAnyPackage(
                    "..adapters.in.controller.request",
                    "..adapters.out.client.request"
            )
            .as("Consumer classes should reside in controller or client package");

    @ArchTest
    public static final ArchRule response_reside_only_response_package = classes()
            .that()
            .haveNameMatching(".*Response")
            .should()
            .resideInAnyPackage(
                    "..adapters.in.controller.response",
                    "..adapters.out.client.response"
            )
            .as("Consumer classes should reside in controller or client package");

    @ArchTest
    public static final ArchRule adapter_reside_only_adapter_package = classes()
            .that()
            .haveNameMatching(".*Adapter")
            .should()
            .resideInAnyPackage(
                    "..adapters.out"
            )
            .as("Consumer classes should reside in adapter package");

    @ArchTest
    public static final ArchRule client_reside_only_client_package = classes()
            .that()
            .haveNameMatching(".*Client")
            .should()
            .resideInAnyPackage(
                    "..adapters.out.client"
            )
            .as("Consumer classes should reside in adapter package");

    @ArchTest
    public static final ArchRule repository_reside_only_repository_package = classes()
            .that()
            .haveNameMatching(".*Repository")
            .should()
            .resideInAnyPackage(
                    "..adapters.out.repository"
            )
            .as("Consumer classes should reside in repository package");

    @ArchTest
    public static final ArchRule entity_reside_only_entity_package = classes()
            .that()
            .haveNameMatching(".*Entity")
            .should()
            .resideInAnyPackage(
                    "..adapters.out.repository.entity"
            )
            .as("Consumer classes should reside in entity package");

    @ArchTest
    public static final ArchRule usecase_reside_only_usecase_package = classes()
            .that()
            .haveNameMatching(".*UC")
            .should()
            .resideInAnyPackage(
                    "..application.core.usecase"
            )
            .as("Consumer classes should reside in usecase package");

    @ArchTest
    public static final ArchRule inputport_reside_only_inpuport_package = classes()
            .that()
            .haveNameMatching(".*InPort")
            .should()
            .resideInAnyPackage(
                    "..application.ports.in"
            )
            .as("Consumer classes should reside in ports in package");

    @ArchTest
    public static final ArchRule outputport_reside_only_outputport_package = classes()
            .that()
            .haveNameMatching(".*OutPort")
            .should()
            .resideInAnyPackage(
                    "..application.ports.out"
            )
            .as("Consumer classes should reside in ports out package");

    @ArchTest
    public static final ArchRule config_reside_only_config_package = classes()
            .that()
            .haveNameMatching(".*Config")
            .should()
            .resideInAnyPackage(
                    "..hexagonal.config"
            )
            .as("Consumer classes should reside in config package");


    @ArchTest
    public static final ArchRule should_be_suffixed_consumer = classes()
            .that()
            .resideInAPackage("..consumer")
            .should()
            .haveSimpleNameEndingWith("Consumer");

    @ArchTest
    public static final ArchRule should_be_suffixed_mapper = classes()
            .that()
            .resideInAPackage("..mapper")
            .should()
            .haveSimpleNameEndingWith("Mapper")
            .orShould()
            .haveSimpleNameEndingWith("MapperImpl");


    @ArchTest
    public static final ArchRule should_be_suffixed_controller = classes()
            .that()
            .resideInAPackage("..controller")
            .should()
            .haveSimpleNameEndingWith("Controller");

    @ArchTest
    public static final ArchRule should_be_suffixed_message = classes()
            .that()
            .resideInAPackage("..message")
            .should()
            .haveSimpleNameEndingWith("Message");

    @ArchTest
    public static final ArchRule should_be_suffixed_request = classes()
            .that()
            .resideInAPackage("..request")
            .should()
            .haveSimpleNameEndingWith("Request");

    @ArchTest
    public static final ArchRule should_be_suffixed_client = classes()
            .that()
            .resideInAPackage("..client")
            .should()
            .haveSimpleNameEndingWith("Client");

    @ArchTest
    public static final ArchRule should_be_suffixed_repository = classes()
            .that()
            .resideInAPackage("..repository")
            .should()
            .haveSimpleNameEndingWith("Repository");

    @ArchTest
    public static final ArchRule should_be_suffixed_entity = classes()
            .that()
            .resideInAPackage("..entity")
            .should()
            .haveSimpleNameEndingWith("Entity");

    @ArchTest
    public static final ArchRule should_be_suffixed_adapter = classes()
            .that()
            .resideInAPackage("..adapters.out")
            .should()
            .haveSimpleNameEndingWith("Adapter");

    @ArchTest
    public static final ArchRule should_be_suffixed_usecase = classes()
            .that()
            .resideInAPackage("..usecase")
            .should()
            .haveSimpleNameEndingWith("UC");

    @ArchTest
    public static final ArchRule should_be_suffixed_input_port = classes()
            .that()
            .resideInAPackage("..ports.in")
            .should()
            .haveSimpleNameEndingWith("InPort");

    @ArchTest
    public static final ArchRule should_be_suffixed_output_port = classes()
            .that()
            .resideInAPackage("..ports.out")
            .should()
            .haveSimpleNameEndingWith("OutPort");

    @ArchTest
    public static final ArchRule should_be_suffixed_config_port = classes()
            .that()
            .resideInAPackage("..config")
            .should()
            .haveSimpleNameEndingWith("Config");


}
