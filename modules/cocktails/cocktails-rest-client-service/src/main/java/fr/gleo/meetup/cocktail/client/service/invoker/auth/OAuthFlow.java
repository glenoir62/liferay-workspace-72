/*
 * Cocktails
 * Cocktail api
 *
 * The version of the OpenAPI document: v1.0
 * Contact: guillaume.lenoir59@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package fr.gleo.meetup.cocktail.client.service.invoker.auth;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-20T14:31:33.017+01:00[Europe/Paris]")
public enum OAuthFlow {
    accessCode, //called authorizationCode  in OpenAPI 3.0
    implicit,
    password,
    application //called clientCredentials in OpenAPI 3.0
}
