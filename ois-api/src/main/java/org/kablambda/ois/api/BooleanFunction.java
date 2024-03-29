package org.kablambda.ois.api;

public enum BooleanFunction {
    FLAGSET("A flag is set. Param: flag"),
    FLAGNOTSET("A flag isnot set. Param: flag"),
    _STATE("Internal check for state of RoomObject, such as the window in the"),
    NAV_TARGET_SELECTED("Has a nav target selected."),
    IS_MOVING("Player ship is moving."),
    MAIN_ENGINE_BURNING("Main engine is burning."),
    HAS_SELECTED_DIRECTION("Has selected a direction on the helm console."),
    HAS_COURSE_PLOTTED("Has a course plotted."),
    AUTO_PILOT_ENGAGED("Travelling via autopilot."),
    AUTO_PILOT_NOT_ENGAGED("Not travellig via autopilot."),
    COURSE_PLOTTED_NOT_ENGAGED("Course plotted, but not engaged."),
    DOCKED_WITH_JUMPGATE("Currently docked with a jumpgate."),
    HAS_SELECTED_OBJECT("Has selected a stellar object on the nav map."),
    MAP_LOCKED_TO_SHIP("Nav map is locked to the player ship."),
    MAP_IN_SECTOR_MODE("Map is in sectors (view whole cluster) mode."),
    PWR_HAS_MODULE_SELECTED("Has a module selected in the power room."),
    PWR_CURRENT_MODULE_ON("Currently selected module in power room is connected."),
    PWR_CURRENT_MODULE_OFF("Currently selected module in power room is disconnected."),
    PWR_CURRENT_MODULE_EMCON_ON("Currently selected module in power room is enabled in EMCON mode."),
    PWR_CURRENT_MODULE_EMCON_OFF("Currently selected module in power room is disabled in EMCON mode."),
    PWR_REACTOR_ON("There is a connected and functional generator."),
    PWR_REACTOR_OFF("There is no connected and functional generator."),
    PWR_CAN_RAISE_PRIORITY("Currently selectd module in power room can have its power priority raised."),
    PWR_CAN_LOWER_PRIORITY("Currently selectd module in power room can have its power priority lowered."),
    IS_STATIONARY("Player ship is stationary."),
    CAN_COME_TO_FULL_STOP("Player ship able to come to a full stop from current state."),
    RCS_BURNING("Player ship RCS is burning."),
    RCS_BURNING_CW("Player ship RCS is burning clockwise."),
    RCS_BURNING_CCW("Player ship RCS is burning counter-clockwise."),
    EMCON_MODE("Player ship is in EMCON Mode."),
    HAS_SELECTED_DESTINATION("Player ship has a valid destination selected."),
    STATUS_WARNING("Player ship hazard level: warning."),
    STATUS_DANGER("Player ship hazard level: danger."),
    STATUS_NOMINAL("Player ship hazard level: nominal."),
    IN_ASTEROID_FIELD("Player ship is in an asteroid field."),
    IN_NEBULA("Player ship is in a nebula."),
    TUBE_HAS_TORPEDO("Currently selected weapon tube contains a torpedo."),
    TUBE_HAS_MINE("Currently selected weapon tube contains a mine."),
    TUBE_HAS_PROBE("Currently selected weapon tube contains a probe."),
    TUBE_CAN_SPIN_UP("Currently selected weapon tube contains a device which can be spun up"),
    TUBE_CAN_FIRE("Currently selected weapon tube can fire."),
    TUBE_CAN_LAUNCH("Currently selected weapon tube can launch."),
    TUBE_LAUNCHED("Currently selected weapon tube has been launched."),
    TUBE_EMPTY("Currently selected weapon tube is empty."),
    TUBE_SPINNING_UP("Currently selected weapon tube is spinning up."),
    TUBE_LINKED("Currently selected weapon tube is linked to a fired device."),
    TUBE_HAS_EXP("Currently selected weapon tube has an explosive-tipped torpedo."),
    TUBE_HAS_EMP("Currently selected weapon tube has an EMP-tipped torpedo."),
    TUBE_CAN_BE_ARMED("Currently selected weapon tube has a fired torpedo that can be armed."),
    TUBE_CAN_POWER_DOWN("Currently selected weapon tube has a fired device that can be remotely shut down."),
    TUBE_CAN_BE_DISABLED("Currently selected weapon tube has a fired device which can be remotely disabled."),
    CAN_SET_TARGET("Can send current coordinates to the selected device in the active weapon system."),
    CAN_CHANGE_TARGET("Can update current coordinates to the selected device in the active weapon system (device already has a target selected)."),
    CANNOT_SET_OR_CHANGE_TARGET("Cannot set or update current coordinates on selected device in weapon system."),
    CAN_ROTATE("Can rotate to a selected orientation using the helm control."),
    PCE_ALARM("PCE Master alarm is lit up."),
    CLUSTER_MODE("Map is in cluster view mode. Parameter: 1 = navcom, 0 = tablet"),
    IS_IN_ORBIT("IS_IN_ORBIT"),
    IS_IN_STANDARD_ORBIT("IS_IN_STANDARD_ORBIT"),
    IS_IN_HIGH_ORBIT("IS_IN_HIGH_ORBIT"),
    IS_IN_POLAR_ORBIT("IS_IN_POLAR_ORBIT"),
    NOT_IN_STANDARD_ORBIT("NOT_IN_STANDARD_ORBIT"),
    NOT_IN_HIGH_ORBIT("NOT_IN_HIGH_ORBIT"),
    NOT_IN_POLAR_ORBIT("NOT_IN_POLAR_ORBIT"),
    IS_IN_FREE_SPACE("IS_IN_FREE_SPACE"),
    IS_CHANGING_ORBIT("IS_CHANGING_ORBIT"),
    IS_LEAVING_ORBIT("IS_LEAVING_ORBIT"),
    IS_ENTERING_ORBIT("IS_ENTERING_ORBIT"),
    IS_CORRECTING_ORBIT("IS_CORRECTING_ORBIT"),
    IS_IN_STABLE_ORBIT("IS_IN_STABLE_ORBIT"),
    NOT_DOCKED("NOT_DOCKED"),
    NOT_DOCKED_OR_MULTIPLAYER("NOT_DOCKED_OR_MULTIPLAYER"),
    NOT_DOCKED_OR_MULTIPLAYER_OR_TUTORIAL("NOT_DOCKED_OR_MULTIPLAYER_OR_TUTORIAL"),
    IS_DOCKED_OR_DOCKING("IS_DOCKED_OR_DOCKING"),
    IS_DOCKED("IS_DOCKED"),
    IS_DOCKING("IS_DOCKING"),
    IS_FULLY_DOCKED("IS_FULLY_DOCKED"),
    IS_UNDOCKING("IS_UNDOCKING"),
    NOT_DOCKING("NOT_DOCKING"),
    NOT_UNDOCKING("NOT_UNDOCKING"),
    CAN_OPEN_AIRLOCK("CAN_OPEN_AIRLOCK"),
    HAS_DOCKING_PERMISSION("HAS_DOCKING_PERMISSION"),
    NEEDS_DOCKING_PERMISSION("NEEDS_DOCKING_PERMISSION"),
    HAS_UNDOCKING_PERMISSION("HAS_UNDOCKING_PERMISSION"),
    NEEDS_UNDOCKING_PERMISSION("NEEDS_UNDOCKING_PERMISSION"),
    CAN_GET_UNDOCKING_PERMISSION("CAN_GET_UNDOCKING_PERMISSION"),
    CANNOT_GET_UNDOCKING_PERMISSION("CANNOT_GET_UNDOCKING_PERMISSION"),
    ANY_AIRLOCK_OPEN("ANY_AIRLOCK_OPEN"),
    ALL_AIRLOCKS_SEALED("ALL_AIRLOCKS_SEALED"),
    AIRLOCKS_CLOSED_BUT_NEEDS_UNDOCK_PERMISSION("AIRLOCKS_CLOSED_BUT_NEEDS_UNDOCK_PERMISSION"),
    CAN_UNDOCK("CAN_UNDOCK"),
    DOCKED_BUT_CANNOT_UNDOCK("DOCKED_BUT_CANNOT_UNDOCK"),
    IFF_ACTIVE("IFF_ACTIVE"),
    SELECTED_OBJECT_CAN_COMMUNICATE("SELECTED_OBJECT_CAN_COMMUNICATE"),
    OWES_MONEY_TO_DOCKED_STATION("OWES_MONEY_TO_DOCKED_STATION"),
    OWES_MONEY_TO_DOCKED_STATION_AND_CANNOT_PAY("OWES_MONEY_TO_DOCKED_STATION_AND_CANNOT_PAY"),
    OWES_MONEY_TO_DOCKED_STATION_AND_CAN_PAY("OWES_MONEY_TO_DOCKED_STATION_AND_CAN_PAY"),
    IS_DOCKED_WITH_STATION("IS_DOCKED_WITH_STATION"),
    IS_DOCKED_WITH_DEPOT("IS_DOCKED_WITH_DEPOT"),
    IS_DOCKED_WITH_JUMPGATE("IS_DOCKED_WITH_JUMPGATE"),
    NEED_TO_PAY_FOR_JUMPGATE("NEED_TO_PAY_FOR_JUMPGATE"),
    CAN_ACTIVATE_JUMPGATE("CAN_ACTIVATE_JUMPGATE"),
    NOT_DOCKED_WITH_STATION("NOT_DOCKED_WITH_STATION"),
    MODULE_REACTOR_UNDAMAGED("MODULE_REACTOR_UNDAMAGED"),
    MODULE_REACTOR_DAMAGED("MODULE_REACTOR_DAMAGED"),
    MODULE_REACTOR_DESTROYED("MODULE_REACTOR_DESTROYED"),
    MODULE_REACTOR_CONNECTED("MODULE_REACTOR_CONNECTED"),
    MODULE_REACTOR_FUNCTIONING("MODULE_REACTOR_FUNCTIONING"),
    MODULE_MAINDRIVE_UNDAMAGED("MODULE_MAINDRIVE_UNDAMAGED"),
    MODULE_MAINDRIVE_DAMAGED("MODULE_MAINDRIVE_DAMAGED"),
    MODULE_MAINDRIVE_DESTROYED("MODULE_MAINDRIVE_DESTROYED"),
    MODULE_MAINDRIVE_CONNECTED("MODULE_MAINDRIVE_CONNECTED"),
    MODULE_RCS_UNDAMAGED("MODULE_RCS_UNDAMAGED"),
    MODULE_RCS_DAMAGED("MODULE_RCS_DAMAGED"),
    MODULE_RCS_DESTROYED("MODULE_RCS_DESTROYED"),
    MODULE_RCS_CONNECTED("MODULE_RCS_CONNECTED"),
    MODULE_COMMS_UNDAMAGED("MODULE_COMMS_UNDAMAGED"),
    MODULE_COMMS_DAMAGED("MODULE_COMMS_DAMAGED"),
    MODULE_COMMS_DESTROYED("MODULE_COMMS_DESTROYED"),
    MODULE_COMMS_CONNECTED("MODULE_COMMS_CONNECTED"),
    MODULE_BATT1_UNDAMAGED("MODULE_BATT1_UNDAMAGED"),
    MODULE_BATT1_DAMAGED("MODULE_BATT1_DAMAGED"),
    MODULE_BATT1_DESTROYED("MODULE_BATT1_DESTROYED"),
    MODULE_BATT1_CONNECTED("MODULE_BATT1_CONNECTED"),
    MODULE_BATT2_UNDAMAGED("MODULE_BATT2_UNDAMAGED"),
    MODULE_BATT2_DAMAGED("MODULE_BATT2_DAMAGED"),
    MODULE_BATT2_DESTROYED("MODULE_BATT2_DESTROYED"),
    MODULE_BATT2_CONNECTED("MODULE_BATT2_CONNECTED"),
    MODULE_BATT3_UNDAMAGED("MODULE_BATT3_UNDAMAGED"),
    MODULE_BATT3_DAMAGED("MODULE_BATT3_DAMAGED"),
    MODULE_BATT3_DESTROYED("MODULE_BATT3_DESTROYED"),
    MODULE_BATT3_CONNECTED("MODULE_BATT3_CONNECTED"),
    MODULE_HELM_UNDAMAGED("MODULE_HELM_UNDAMAGED"),
    MODULE_HELM_DAMAGED("MODULE_HELM_DAMAGED"),
    MODULE_HELM_DESTROYED("MODULE_HELM_DESTROYED"),
    MODULE_HELM_CONNECTED("MODULE_HELM_CONNECTED"),
    MODULE_SENSORS_UNDAMAGED("MODULE_SENSORS_UNDAMAGED"),
    MODULE_SENSORS_DAMAGED("MODULE_SENSORS_DAMAGED"),
    MODULE_SENSORS_DESTROYED("MODULE_SENSORS_DESTROYED"),
    MODULE_SENSORS_CONNECTED("MODULE_SENSORS_CONNECTED"),
    MODULE_NAVCOM_UNDAMAGED("MODULE_NAVCOM_UNDAMAGED"),
    MODULE_NAVCOM_DAMAGED("MODULE_NAVCOM_DAMAGED"),
    MODULE_NAVCOM_DESTROYED("MODULE_NAVCOM_DESTROYED"),
    MODULE_NAVCOM_CONNECTED("MODULE_NAVCOM_CONNECTED"),
    MODULE_WEAP_UNDAMAGED("MODULE_WEAP_UNDAMAGED"),
    MODULE_WEAP_DAMAGED("MODULE_WEAP_DAMAGED"),
    MODULE_WEAP_DESTROYED("MODULE_WEAP_DESTROYED"),
    MODULE_WEAP_CONNECTED("MODULE_WEAP_CONNECTED"),
    MODULE_JUMPDRIVE_UNDAMAGED("MODULE_JUMPDRIVE_UNDAMAGED"),
    MODULE_JUMPDRIVE_DAMAGED("MODULE_JUMPDRIVE_DAMAGED"),
    MODULE_JUMPDRIVE_DESTROYED("MODULE_JUMPDRIVE_DESTROYED"),
    MODULE_JUMPDRIVE_CONNECTED("MODULE_JUMPDRIVE_CONNECTED"),
    MODULE_BOOTING("MODULE_BOOTING"),
    MODULE_DISCONNECTED("MODULE_DISCONNECTED"),
    SHOW_SPACE_DISC("SHOW_SPACE_DISC"),
    DONT_SHOW_SPACE_DISC("DONT_SHOW_SPACE_DISC"),
    TUBE_1_SELECTED("TUBE_1_SELECTED"),
    TUBE_2_SELECTED("TUBE_2_SELECTED"),
    TUBE_3_SELECTED("TUBE_3_SELECTED"),
    TUBE_4_SELECTED("TUBE_4_SELECTED"),
    TUBE_5_SELECTED("TUBE_5_SELECTED"),
    TUBE_6_SELECTED("ENG_MODULE_ON"),
    TUBE_7_SELECTED("ENG_MODULE_OFF"),
    TUBE_8_SELECTED("ENG_MODULE_CAN_OPEN"),
    ENG_MODULE_ON("ENG_MODULE_OPEN"),
    ENG_MODULE_OFF("ENG_NO_MODULE_OPEN"),
    ENG_MODULE_CAN_OPEN("ENG_CAN_CLOSE_CURRENT_MODULE"),
    ENG_MODULE_OPEN("ENG_MODULE_CAN_BE_CONNECTED"),
    ENG_NO_MODULE_OPEN("ENG_NO_TRAY_OBJECT_SELECTED"),
    ENG_CAN_CLOSE_CURRENT_MODULE("ENG_CAN_REPAIR_COMPONENT"),
    ENG_MODULE_CAN_BE_CONNECTED("ENG_IS_REPAIRING"),
    ENG_NO_TRAY_OBJECT_SELECTED("JMP_CAN_SET_JUMP_DESTINATION"),
    ENG_CAN_REPAIR_COMPONENT("JMP_CANNOT_SET_JUMP_DESTINATION"),
    ENG_IS_REPAIRING("JMP_CAN_SPIN_UP_JUMP_DRIVE"),
    JMP_CAN_SET_JUMP_DESTINATION("JMP_CANNOT_SPIN_UP_JUMP_DRIVE"),
    JMP_CANNOT_SET_JUMP_DESTINATION("JMP_CAN_CALC_JUMP"),
    JMP_CAN_SPIN_UP_JUMP_DRIVE("JMP_CANNOT_CALC_JUMP"),
    JMP_CANNOT_SPIN_UP_JUMP_DRIVE("JMP_CAN_JUMP"),
    JMP_CAN_CALC_JUMP("JMP_CANNOT_JUMP"),
    JMP_CANNOT_CALC_JUMP("JMP_CAN_DISCHARGE_JUMP_DRIVE"),
    JMP_CAN_JUMP("JMP_CANNOT_DISCHARGE_JUMP_DRIVE"),
    JMP_CANNOT_JUMP("JMP_HAS_JUMP_DRIVE"),
    JMP_CAN_DISCHARGE_JUMP_DRIVE("JMP_HAS_NO_JUMP_DRIVE"),
    JMP_CANNOT_DISCHARGE_JUMP_DRIVE("JMP_IS_SPINNING_UP"),
    JMP_HAS_JUMP_DRIVE("JMP_IS_CALCULATING_JUMP"),
    JMP_HAS_NO_JUMP_DRIVE("JMP_IS_SPUN_UP"),
    JMP_IS_SPINNING_UP("JMP_IS_CALCULATED"),
    JMP_IS_CALCULATING_JUMP("PWR_LOW_POWER_WARNING"),
    JMP_IS_SPUN_UP("PWR_IS_DRAINING"),
    JMP_IS_CALCULATED("PWR_IS_GENERATING"),
    PWR_LOW_POWER_WARNING("IS_TURNED_ON"),
    PWR_IS_DRAINING("IS_TURNED_OFF"),
    PWR_IS_GENERATING("CAN_TELEPORT"),
    IS_TURNED_ON("SENSORS_NAV_LINKED"),
    IS_TURNED_OFF("SENSORS_HISTORY_LOCKED"),
    CAN_TELEPORT("SENSORS_AUTO"),
    SENSORS_NAV_LINKED("LADAR_ACTIVE"),
    SENSORS_HISTORY_LOCKED("LADAR_FUNCTIONAL"),
    SENSORS_AUTO("LADAR_INACTIVE"),
    LADAR_ACTIVE("MAIN_DRIVE_FUNCTIONAL"),
    LADAR_FUNCTIONAL("CM_EXISTS"),
    LADAR_INACTIVE("CM_CANLAUNCH"),
    MAIN_DRIVE_FUNCTIONAL("CM_CANNOTLAUNCH"),
    CM_EXISTS("PDS_EXISTS"),
    CM_CANLAUNCH("PDS_ACTIVE"),
    CM_CANNOTLAUNCH("PDS_INACTIVE"),
    PDS_EXISTS("COMMS_AUTOSYNC_ON"),
    PDS_ACTIVE("VALID_TRAVEL_TARGET_SELECTED"),
    PDS_INACTIVE("CAN_ADD_WAYPOINT"),
    COMMS_AUTOSYNC_ON("IS_MOORED"),
    VALID_TRAVEL_TARGET_SELECTED("IS_MOORED_TO_DEBRIS"),
    CAN_ADD_WAYPOINT("IS_MOORED_TO_CARGO"),
    IS_MOORED("HAS_GRAPPLING_ARM"),
    IS_MOORED_TO_DEBRIS("GRAPPLING_ARM_IN_USE"),
    IS_MOORED_TO_CARGO("CAN_GRAPPLE_MOORED"),
    HAS_GRAPPLING_ARM("CAN_GRAPPLE_SHIP"),
    GRAPPLING_ARM_IN_USE("CAN_JETTISON"),
    CAN_GRAPPLE_MOORED("CAN_JETTISON_ALL"),
    CAN_GRAPPLE_SHIP("CAN_HACK"),
    CAN_JETTISON("CANNOT_HACK"),
    CAN_JETTISON_ALL("HAS_HACKING_UNIT"),
    CAN_HACK("IS_HACKING"),
    CANNOT_HACK("BEING_HAILED"),
    HAS_HACKING_UNIT("SHOULD_SHOW_CARGO_SCREEN"),
    IS_HACKING("CAN_REPAIR_HULL_AT_DEPOT"),
    BEING_HAILED("CANNOT_REPAIR_HULL_AT_DEPOT"),
    SHOULD_SHOW_CARGO_SCREEN("CAN_REPAIR_MODULES_AT_DEPOT"),
    CAN_REPAIR_HULL_AT_DEPOT("CANNOT_REPAIR_MODULES_AT_DEPOT"),
    CANNOT_REPAIR_HULL_AT_DEPOT("CAN_REARM_AT_DEPOT"),
    CAN_REPAIR_MODULES_AT_DEPOT("CANNOT_REARM_AT_DEPOT"),
    CANNOT_REPAIR_MODULES_AT_DEPOT("CAN_BUY_CM_AT_DEPOT"),
    CAN_REARM_AT_DEPOT("CANNOT_BUY_CM_AT_DEPOT"),
    CANNOT_REARM_AT_DEPOT("CAN_JUMP_IN_TUTORIAL"),
    CAN_BUY_CM_AT_DEPOT("CAN_DETECT_CASSANDRA"),
    CANNOT_BUY_CM_AT_DEPOT("JUMPDRIVE_ACTIVE"),
    CAN_JUMP_IN_TUTORIAL("PDL_ACTIVE"),
    CAN_DETECT_CASSANDRA("LADAR_DETECTED"),
    JUMPDRIVE_ACTIVE("MENU_MAIN"),
    PDL_ACTIVE("SUBMENU_OPTIONS"),
    LADAR_DETECTED("SUBMENU_INPUT"),
    MENU_MAIN("SUBMENU_NEWS"),
    SUBMENU_OPTIONS("SUBMENU_CREDITS"),
    SUBMENU_INPUT("SUBMENU_GAMEOVER"),
    SUBMENU_NEWS("TRADE_HASPURCHASE"),
    SUBMENU_CREDITS("TRADE_VALIDPURCHASE"),
    SUBMENU_GAMEOVER("TRADE_INVALIDPURCHASE"),
    TRADE_HASPURCHASE("TRADE_HASSALE"),
    TRADE_VALIDPURCHASE("TRADE_VALIDSALE"),
    TRADE_INVALIDPURCHASE("TRADE_INVALIDSALE"),
    TRADE_HASSALE("TRADE_HASPURCHASEORSALE"),
    TRADE_VALIDSALE("COMMERCE_ATMENU"),
    TRADE_INVALIDSALE("COMMERCE_NOTATMENU"),
    TRADE_HASPURCHASEORSALE("COMMERCE_MENUIS"),
    COMMERCE_ATMENU("COMMERCE_CANPURCHASELICENSE"),
    COMMERCE_NOTATMENU("COMMERCE_CANNOTPURCHASELICENSE"),
    COMMERCE_MENUIS("COMMERCE_LOANGIVERSELECTED"),
    COMMERCE_CANPURCHASELICENSE("COMMERCE_LOANGIVERNOTSELECTED"),
    COMMERCE_CANNOTPURCHASELICENSE("COMMERCE_REPAYINGLOAN"),
    COMMERCE_LOANGIVERSELECTED("COMMERCE_LOANVALID"),
    COMMERCE_LOANGIVERNOTSELECTED("COMMERCE_LOANINVALID"),
    COMMERCE_REPAYINGLOAN("COMMERCE_REPAYMENTVALID"),
    COMMERCE_LOANVALID("COMMERCE_REPAYMENTINVALID"),
    COMMERCE_LOANINVALID("COMMERCE_CANTAKECONTRACT"),
    COMMERCE_REPAYMENTVALID("COMMERCE_CANNOTTAKECONTRACT"),
    COMMERCE_REPAYMENTINVALID("COMMERCE_CANDELIVERCONTRACT"),
    COMMERCE_CANTAKECONTRACT("COMMERCE_CANNOTDELIVERCONTRACT"),
    COMMERCE_CANNOTTAKECONTRACT("COMMERCE_CANTAKEPASSENGER"),
    COMMERCE_CANDELIVERCONTRACT("COMMERCE_CANNOTTAKEPASSENGER"),
    COMMERCE_CANNOTDELIVERCONTRACT("WIRE_VISIBLE"),
    COMMERCE_CANTAKEPASSENGER("MECHANIC_ATMENU"),
    COMMERCE_CANNOTTAKEPASSENGER("MECHANIC_AT"),
    WIRE_VISIBLE("MECHANIC_CAN_REPAIR"),
    MECHANIC_ATMENU("MECHANIC_CANNOT_REPAIR"),
    MECHANIC_AT("MECHANIC_CAN_BUY_POD"),
    MECHANIC_CAN_REPAIR("MECHANIC_CANNOT_BUY_POD"),
    MECHANIC_CANNOT_REPAIR("MECHANIC_CAN_SELL_POD"),
    MECHANIC_CAN_BUY_POD("MECHANIC_CANNOT_SELL_POD"),
    MECHANIC_CANNOT_BUY_POD("MECHANIC_CAN_UPGRADE_POD"),
    MECHANIC_CAN_SELL_POD("MECHANIC_CANNOT_UPGRADE_POD"),
    MECHANIC_CANNOT_SELL_POD("MECHANIC_CAN_BUY_MODULE"),
    MECHANIC_CAN_UPGRADE_POD("MECHANIC_CANNOT_BUY_MODULE"),
    MECHANIC_CANNOT_UPGRADE_POD("MECHANIC_CAN_SELL_MODULE"),
    MECHANIC_CAN_BUY_MODULE("MECHANIC_CANNOT_SELL_MODULE"),
    MECHANIC_CANNOT_BUY_MODULE("MECHANIC_CAN_BUY_ARMAMENT"),
    MECHANIC_CAN_SELL_MODULE("MECHANIC_CANNOT_BUY_ARMAMENT"),
    MECHANIC_CANNOT_SELL_MODULE("MECHANIC_CAN_SELL_ARMAMENT"),
    MECHANIC_CAN_BUY_ARMAMENT("MECHANIC_CANNOT_SELL_ARMAMENT"),
    MECHANIC_CANNOT_BUY_ARMAMENT("BUYING_MODULES"),
    MECHANIC_CAN_SELL_ARMAMENT("SHIP_CANBUY"),
    MECHANIC_CANNOT_SELL_ARMAMENT("SHIP_CANNOTBUY"),
    BUYING_MODULES("MOORED_WRECK_HAS_NOT_DOWNLOADED_DATA"),
    SHIP_CANBUY("MOORED_WRECK_HAS_DOWNLOADED_DATA"),
    SHIP_CANNOTBUY("MOORED_WRECK_HAS_UNCLAMPED_CARGO"),
    MOORED_WRECK_HAS_NOT_DOWNLOADED_DATA("MOORED_WRECK_HAS_NOT_UNCLAMPED_CARGO"),
    MOORED_WRECK_HAS_DOWNLOADED_DATA("CAN_BOARD_BROKER_SHIP"),
    MOORED_WRECK_HAS_UNCLAMPED_CARGO("CAN_NOT_BOARD_BROKER_SHIP"),
    MOORED_WRECK_HAS_NOT_UNCLAMPED_CARGO("IS_VIEWING_SELECTED_SHIP"),
    CAN_BOARD_BROKER_SHIP("IS_NOT_VIEWING_SELECTED_SHIP"),
    CAN_NOT_BOARD_BROKER_SHIP("HAS_EMAILS_TO_DOWNLOAD"),
    IS_VIEWING_SELECTED_SHIP("STARTING_NEW_GAME"),
    IS_NOT_VIEWING_SELECTED_SHIP("NEW_GAME_OPTIONS"),
    HAS_EMAILS_TO_DOWNLOAD("CONVERSATION_ACTIVE"),
    STARTING_NEW_GAME("MUSIC_PLAYING"),
    NEW_GAME_OPTIONS("MUSIC_NOT_PLAYING"),
    CONVERSATION_ACTIVE("CAN_USE_MUSIC"),
    MUSIC_PLAYING("SOS is active"),
    MUSIC_NOT_PLAYING("SOS can be activated"),
    CAN_USE_MUSIC("Ship is disabled"),
    SOS_ACTIVE("COMMERCE_CANTAKEBOUNTY"),
    SOS_CAN_BE_ACTIVATED("COMMERCE_CANNOTTAKEBOUNTY"),
    SHIP_DISABLED("RESOLUTION_CHANGED"),
    COMMERCE_CANTAKEBOUNTY("CAN_BEGIN_DOCK"),
    COMMERCE_CANNOTTAKEBOUNTY("CANNOT_BEGIN_DOCK"),
    RESOLUTION_CHANGED("DOCKED_WITH_EARTHGATE"),
    CAN_BEGIN_DOCK("CAN_CHANGE_DETAILS"),
    CANNOT_BEGIN_DOCK("CAN_BEGIN_GAME"),
    DOCKED_WITH_EARTHGATE("CAN_CONTINUE_GAME"),
    CAN_CHANGE_DETAILS("CAN_DELETE_SAVE"),
    CAN_BEGIN_GAME("CAN_CONFIRM_DELETE"),
    CAN_CONTINUE_GAME("CAN_BEGIN_STORY"),
    CAN_DELETE_SAVE("CAN_JETTISON_COMPONENT"),
    CAN_CONFIRM_DELETE("CONNECTED_TO_SERVER"),
    CAN_BEGIN_STORY("CAN_CONNECT_TO_SERVER"),
    CAN_JETTISON_COMPONENT("CANNOT_CONNECT_TO_SERVER"),
    CONNECTED_TO_SERVER("CAN_DISCONNECT_FROM_SERVER"),
    CAN_CONNECT_TO_SERVER("CANNOT_DISCONNECT_FROM_SERVER"),
    CANNOT_CONNECT_TO_SERVER("Can send Ready state to server"),
    CAN_DISCONNECT_FROM_SERVER("Can remove Ready state from server"),
    CANNOT_DISCONNECT_FROM_SERVER("Cannot send Ready state to server"),
    CAN_SEND_CHAT_MESSAGE("CAN_SEND_CHAT_MESSAGE"),
    CANNOT_SEND_CHAT_MESSAGE("CANNOT_SEND_CHAT_MESSAGE"),
    CAN_SEND_READY_STATE("PIRATE_REPORTED"),
    CAN_REMOVE_READY_STATE("SMUGGLER_DETECTED"),
    CANNOT_SEND_READY_STATE_CHANGE("CAN_TAKE_SHIP"),
    PIRATE_REPORTED("CANNOT_TAKE_SHIP"),
    SMUGGLER_DETECTED("(null)"),
    CAN_TAKE_SHIP("(null)"),
    CANNOT_TAKE_SHIP("(null)");

    final private String description;

    BooleanFunction(java.lang.String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}