package com.example.demo.enums;

public enum CommandType {
    REGISTER("register"),
    LOGIN("login"),
    EXIT("exit"),
    SEARCH_USER_BY_LOGIN("search_user_by_login"),
    LOGOUT("logout"),
    INFO("info"),
    SEND_MESSAGE("send_message"),
    ALL_USERS("all_users"),
    MAIL_INFO("mail_info"),
    READ_ALL_MESSAGE("read_all_message"),
    HELP("help");

    private final String commandName;

    CommandType(String command) {
        this.commandName = command;
    }

    public static CommandType listOfAllCommands(String command)  {
        for (CommandType type : CommandType.values()) {
            if (type.commandName.equalsIgnoreCase(command)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Такой команды нет в системе : " + command);
    }
}
