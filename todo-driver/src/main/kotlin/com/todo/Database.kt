package com.todo

import org.ktorm.database.Database

val database = Database.connect("jdbc:mysql://localhost:3306/ktorm", user = "root", password = "root")