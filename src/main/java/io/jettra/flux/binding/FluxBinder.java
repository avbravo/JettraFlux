package io.jettra.flux.binding;

import java.lang.reflect.Field;
import java.util.Map;
import io.jettra.rules.core.JettraRulesEngine;
import io.jettra.rules.core.JettraComputeEngine;
import io.jettra.rules.core.RuleResult;

public class FluxBinder {
    private final Object model;
    private java.util.Properties messages;
    
    public FluxBinder(Object model) {
        this.model = model;
    }
    
    public FluxBinder messages(java.util.Properties messages) {
        this.messages = messages;
        return this;
    }
    
    public FluxBinder bind(Map<String, String> params) {
        if (model == null || params == null) return this;
        
        for (Field field : model.getClass().getDeclaredFields()) {
            if (params.containsKey(field.getName())) {
                String valueStr = params.get(field.getName());
                try {
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    
                    if (type == String.class) {
                        field.set(model, valueStr);
                    } else if (type == Integer.class || type == int.class) {
                        if (valueStr == null || valueStr.trim().isEmpty()) {
                            if (type == Integer.class) field.set(model, null);
                            else field.set(model, 0);
                        } else {
                            field.set(model, Integer.parseInt(valueStr.trim()));
                        }
                    } else if (type == Double.class || type == double.class) {
                        if (valueStr == null || valueStr.trim().isEmpty()) {
                            if (type == Double.class) field.set(model, null);
                            else field.set(model, 0.0);
                        } else {
                            field.set(model, Double.parseDouble(valueStr.trim()));
                        }
                    } else if (type == Long.class || type == long.class) {
                        if (valueStr == null || valueStr.trim().isEmpty()) {
                            if (type == Long.class) field.set(model, null);
                            else field.set(model, 0L);
                        } else {
                            field.set(model, Long.parseLong(valueStr.trim()));
                        }
                    } else if (type == Boolean.class || type == boolean.class) {
                        field.set(model, Boolean.parseBoolean(valueStr));
                    }
                } catch (Exception e) {
                    System.err.println("[FluxBinder] Error binding " + field.getName() + ": " + e.getMessage());
                }
            }
        }
        return this;
    }
    
    public java.util.List<RuleResult> validate() {
        if (model == null) {
            java.util.List<RuleResult> err = new java.util.ArrayList<>();
            err.add(new RuleResult(false, "Model is null", "Model"));
            return err;
        }
        return JettraRulesEngine.validate(model, messages);
    }
    
    public FluxBinder compute() {
        if (model != null) {
            try {
                JettraComputeEngine.compute(model);
            } catch(Exception e) {
                System.err.println("[FluxBinder] Compute Error: " + e.getMessage());
            }
        }
        return this;
    }
    
    public Object getModel() {
        return model;
    }
}
