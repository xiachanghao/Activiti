package org.activiti.spring.conformance.variables;

import org.activiti.api.model.shared.event.RuntimeEvent;
import org.activiti.api.model.shared.event.VariableCreatedEvent;
import org.activiti.api.model.shared.event.VariableDeletedEvent;
import org.activiti.api.model.shared.event.VariableUpdatedEvent;
import org.activiti.api.process.model.events.BPMNActivityCancelledEvent;
import org.activiti.api.process.model.events.BPMNActivityCompletedEvent;
import org.activiti.api.process.model.events.BPMNActivityStartedEvent;
import org.activiti.api.process.model.events.BPMNSequenceFlowTakenEvent;
import org.activiti.api.process.runtime.events.*;
import org.activiti.api.process.runtime.events.listener.BPMNElementEventListener;
import org.activiti.api.process.runtime.events.listener.ProcessRuntimeEventListener;
import org.activiti.api.runtime.shared.events.VariableEventListener;
import org.activiti.api.task.runtime.events.*;
import org.activiti.api.task.runtime.events.listener.TaskEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class VariablesRuntimeTestConfiguration {

    public static List<RuntimeEvent> collectedEvents = new ArrayList<>();

    @Bean
    public BPMNElementEventListener<BPMNActivityStartedEvent> bpmnActivityStartedListener() {
        return bpmnActivityStartedEvent -> collectedEvents.add(bpmnActivityStartedEvent);
    }

    @Bean
    public BPMNElementEventListener<BPMNActivityCompletedEvent> bpmnActivityCompletedListener() {
        return bpmnActivityCompletedEvent -> collectedEvents.add(bpmnActivityCompletedEvent);
    }

    @Bean
    public BPMNElementEventListener<BPMNSequenceFlowTakenEvent> bpmnSequenceFlowTakenListener() {
        return bpmnSequenceFlowTakenEvent -> collectedEvents.add(bpmnSequenceFlowTakenEvent);
    }

    @Bean
    public ProcessRuntimeEventListener<ProcessCreatedEvent> processCreatedListener() {
        return processCreatedEvent -> collectedEvents.add(processCreatedEvent);
    }

    @Bean
    public ProcessRuntimeEventListener<ProcessStartedEvent> processStartedListener() {
        return processStartedEvent -> collectedEvents.add(processStartedEvent);
    }

    @Bean
    public VariableEventListener<VariableCreatedEvent> variableCreatedEventListener() {
        return variableCreatedEvent -> collectedEvents.add(variableCreatedEvent);
    }

    @Bean
    public VariableEventListener<VariableDeletedEvent> variableDeletedEventListener() {
        return variableDeletedEvent -> collectedEvents.add(variableDeletedEvent);
    }

    @Bean
    public VariableEventListener<VariableUpdatedEvent> variableUpdatedEventListener() {
        return variableUpdatedEvent -> collectedEvents.add(variableUpdatedEvent);
    }

    @Bean
    public TaskEventListener<TaskCreatedEvent> taskCreatedEventListener() {
        return taskCreatedEvent -> collectedEvents.add(taskCreatedEvent);
    }

    @Bean
    public TaskEventListener<TaskAssignedEvent> taskAssignedEventListener() {
        return taskAssignedEvent -> collectedEvents.add(taskAssignedEvent);
    }
}
