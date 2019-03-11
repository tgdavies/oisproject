package org.kablambda.ois.proxy;

import org.kablambda.ois.api.BooleanFunction;
import org.kablambda.ois.api.NumericalCommand;
import org.kablambda.ois.api.ShipCommand;

import java.util.Optional;

public interface OisState {
    Optional<Boolean> get(BooleanFunction f);
    Optional<Double> get(NumericalCommand f);
    OisStateEvent getEvent() throws InterruptedException;
    void send(ShipCommand command);

    interface OisStateEvent {
        <T> T accept(OisStateEventVisitor<T> visitor);
    }

    interface OisStateEventVisitor<T> {
        T onBooleanFunctionChanged(BooleanFunctionChanged event);
        T onNumericalCommandChanged(NumericalCommandChanged event);
        T onActive();
    }

    class BooleanFunctionChanged implements OisStateEvent {
        private final BooleanFunction booleanFunction;
        private final Boolean oldValue;
        private final boolean newValue;

        public BooleanFunctionChanged(BooleanFunction booleanFunction, Boolean oldValue, boolean newValue) {
            this.booleanFunction = booleanFunction;
            this.oldValue = oldValue;
            this.newValue = newValue;
        }

        public BooleanFunction getBooleanFunction() {
            return booleanFunction;
        }

        public Boolean getOldValue() {
            return oldValue;
        }

        public boolean getNewValue() {
            return newValue;
        }

        @Override
        public <T> T accept(OisStateEventVisitor<T> visitor) {
            return visitor.onBooleanFunctionChanged(this);
        }
    }

    class NumericalCommandChanged implements OisStateEvent {
        private final NumericalCommand numericalCommand;
        private final Double oldValue;
        private final double newValue;

        public NumericalCommandChanged(NumericalCommand numericalCommand, Double oldValue, double newValue) {
            this.numericalCommand = numericalCommand;
            this.oldValue = oldValue;
            this.newValue = newValue;
        }

        public NumericalCommand getNumericalCommand() {
            return numericalCommand;
        }

        public Double getOldValue() {
            return oldValue;
        }

        public double getNewValue() {
            return newValue;
        }

        @Override
        public <T> T accept(OisStateEventVisitor<T> visitor) {
            return visitor.onNumericalCommandChanged(this);
        }
    }

    class OnActive implements OisStateEvent {

        @Override
        public <T> T accept(OisStateEventVisitor<T> visitor) {
            return visitor.onActive();
        }
    }
}
