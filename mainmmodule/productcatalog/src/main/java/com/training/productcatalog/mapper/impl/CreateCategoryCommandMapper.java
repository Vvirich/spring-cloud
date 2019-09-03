package com.training.productcatalog.mapper.impl;

import com.training.productcatalog.mapper.Mapper;
import com.training.productcatalog.request.CategoryRequest;
import io.sphere.sdk.categories.CategoryDraft;
import io.sphere.sdk.categories.CategoryDraftBuilder;
import io.sphere.sdk.categories.commands.CategoryCreateCommand;
import io.sphere.sdk.models.LocalizedString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreateCategoryCommandMapper implements Mapper<CategoryCreateCommand, CategoryRequest> {

    @Override
    public CategoryCreateCommand map(CategoryRequest request) {
        final Locale locale = request.getLocale();
        final CategoryDraft draft = CategoryDraftBuilder
                .of(getLocalizedString(locale, request.getName()), getLocalizedString(locale, request.getSlug()))
                .description(getLocalizedString(locale, request.getDescription()))
                .key(request.getKey())
                .orderHint(request.getOrderHint())
                .build();
        return CategoryCreateCommand.of(draft);
    }

    private LocalizedString getLocalizedString(Locale locale, String parameter) {
        return LocalizedString.of(locale, parameter);
    }
}
