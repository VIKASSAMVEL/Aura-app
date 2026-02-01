package com.aura.app.core.accessibility;

import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = AuraAccessibilityService.class
)
@GeneratedEntryPoint
@InstallIn(ServiceComponent.class)
public interface AuraAccessibilityService_GeneratedInjector {
  void injectAuraAccessibilityService(AuraAccessibilityService auraAccessibilityService);
}
