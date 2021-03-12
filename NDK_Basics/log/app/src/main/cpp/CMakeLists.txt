cmake_minimum_required(VERSION 3.10.2)

project(log)

find_library(lib-log log)

add_library(myLog SHARED log.cpp)

link_libraries(myLog ${myLog})