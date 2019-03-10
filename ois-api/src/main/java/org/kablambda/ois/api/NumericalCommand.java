package org.kablambda.ois.api;

public enum NumericalCommand {
    POWER_LEVEL("Total current power stored in kw."),
    POWER_LEVEL_PERCENT(
            "Total current power as a percentage."),
    POWER_FLOW(
            "Total power flow, in positive or negative amounts."),
    POWER_FLOW_PERCENT(
            "Total power flow, in percent."),
    POWER_GENERATION(
            "Total power generated currently."),
    POWER_GENERATION_PERCENT(
            "Total power generated currently, in percent of theoretical max."),
    POWER_DRAIN(
            "Total power drain currently."),
    POWER_DRAIN_PERCENT(
            "Total power drain currently, in percent of theoretical max."),
    DESIRED_DIRECTION(
            "Desired directions elected on helm panel."),
    MOTION_ANGLE(
            "Current motion angle."),
    DIRECTION("Current ship direction."),
    CURRENT_SPEED(
            "Current speed."),
    CURRENT_SPEED_PERCENT(
            "Current speed as percent of theoretical max."),
    PRESSURE_EXTERIOR(
            "Exterior airlock pressure."),
    PRESSURE_INTERIOR(
            "Interior airlock pressure."),
    PRESSURE_AIRLOCK(
            "Pressure inside the airlock."),
    CURRENT_TEMPERATURE(
            "Current temperature inside the ship."),
    CURRENT_DISTANCE(
            "Current distance to selected object."),
    CURRENT_BEARING(
            "Current bearing to selected object."),
    ASTEROID_DENSITY(
            "Current density of asteroid field outside."),
    NEBULA_DENSITY(
            "Current density of nebula outside."),
    TUBE_SELECTED(
            "Currently selected tube (0-7)."),
    AMOUNT_OWED_TO_DOCKED(
            "Amount owed to currently docked station."),
    AMOUNT_OWED_VIA_COMMS(
            "Amount owed to space station currently communicating with."),
    AUTO_REPAIR_PERCENT(
            "[no longer used]"),
    CURRENT_TUBE_SPIN_UP_PERCENT(
            "Spin up percent of currently selected tube."),
    TUBE_SPIN_UP_PERCENT(
            "Spin up percent of any tube (parameter: 1-8)"),
    ENG_CURRENT_REPAIR_PERCENT(
            "[no longer used]"),
    JMP_SOLUTION("Jump drive solution percent."),
    MAIN_DRIVE_POWER_LEVEL(
            "Main drive current power level in percent."),
    HULL_TEMPERATURE(
            "Current hull temperature."),
    SOLAR_RADIATION_PERCENT(
            "External solar radiation percent."),
    GRAPPLE_ARM_PERCENTAGE(
            "Percentage of current grappling arm operation."),
    HACK_PERCENTAGE(
            "Percentage of current hack operation."),
    PENDING_EMAILS(
            "Number of emails pending to download."),
    UNREAD_EMAILS(
            "Number of downloaded but unread emails."),
    READ_EMAILS(
            "Number of downloaded but read emails."),
    PLAYER_CREDITS(
            "Current number of player credits.");

    final private String description;

    NumericalCommand(java.lang.String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}