# Some data sample analysis done during interview 

## Installation

0. Make sure you have java 1.8 JRE and JDK installed
1. Navigate into project root directory
2. Run `./activator 'run [data file] uid1 uid2'`

## Definition of "meeting"
I'm assuming that both persons were within a distance of 3 meters in 1 minute time frame

## Bonuses
* Detecting time and location of meet
* No external database
* Use of functional language
* Modular and testable components

## Things I could improve
* Remove noise, maybe some clustering algorithm
* Add grouping by floors, and run the search in parallel on each floor
