package com.zetta.fuxt.service.product.management.expose.web;

import com.zetta.fuxt.service.product.management.util.header.manager.RequestHeaderObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;

/**
 * Controlador principal que expone la funcionalidad de creación de productos
 * a tra&eacute;s de Http/rest para las aplicaciones clientes. <br/>
 * <b>Class</b>: CreateProductController <br/>
 * <b>Package</b>: com.zetta.fuxt.service.product.management.expose.web <br/>
 * <b>Project</b>: products-service <br/>
 * <b>Version</b>: 1.0.0 <br/>
 * <b>Company</b>: Zetta Technology Studios <br/>
 * <b>Creation Date</b>: 2024-03-16 <br/>
 * <b>Copyright</b>: Zetta Technology Studios (ZTS) <br/>
 * @author Zetta Technology Studios (ZTS) <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Pablo Sergio Loyola Tantaruna</li>
 * </ul>
 * <u>Reviewed by</u>: <br/>
 * <li>Pablo Sergio Loyola Tantaruna</li>
 * </ul>
 * <li>Version 1.0.0</li>
 *
 *
 */

@RefreshScope
@RestController
@Tag(name = "CreateProduct")
@RequestMapping("/add-products")
@Slf4j
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductService createProductService;
    private final AfterProcessFilter afterProcessFilter;
    private final Environment env;
    private final ErrorProperties errorProperties;

    @InitBinder
    public void initBinder(DataBinder dataBinder) {dataBinder.setDisallowedFields();}

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(tags = "CreateProductResponse",
            summary = "Se cre&oacute; un nuevo producto correctamente",
            method = "POST",
            description = "classpath:swagger/notes/create-product.md",
            responses = {
                    @ApiResponse(responseCode = "201",
                            description = "El producto fue creado correctamente",
                            content = @Content(schema = @Schema(implementation = CreateProductResponse.class))),
                    @ApiResponse(responseCode = "400",
                            description = "La solicitud es incorrecta",
                            content = @Content(schema = @Schema(implementation = ApiException.class))),
                    @ApiResponse(responseCode = "401",
                            description = "No autorizado",
                            content = @Content(schema = @Schema(implementation = ApiException.class))),
                    @ApiResponse(responseCode = "403",
                            description = "Prohibido",
                            content = @Content(schema = @Schema(implementation = ApiException.class))),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor",
                            content = @Content(schema = @Schema(implementation = ApiException.class))),
                    @ApiResponse(responseCode = "503",
                            description = "Servicio no disponible",
                            content = @Content(schema = @Schema(implementation = ApiException.class))) })
    @ResponseStatus(HttpStatus.CREATED)
    public Single<CreateProductResponse> createProduct(
            @ParameterObject
            @RequestHeaderObject ApiHeader apiHeader,
            @RequestBody CreateProductRequest createProductRequest,
            ServerWebExchange serverWebExchange) {
        return createProductService.executeCreateProduct(apiHeader, createProductRequest)
                .doOnSuccess(createProductResponse -> afterProcessFilter
                        .processResult(null, Action.CREATE_PRODUCT, apiHeader, serverWebExchange, env))
                        .doOnError(throwable -> afterProcessFilter
                                .processResult(throwable, Action.CREATE_PRODUCT, apiHeader, serverWebExchange, env))
                        .onErrorResumeNext(ex -> Single.error(ExceptionUtils
                                .buildApiException(ex, Action.CREATE_PRODUCT, env, errorProperties.getCodeDescriptionType())));
    }
}
