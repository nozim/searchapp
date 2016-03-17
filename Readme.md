## Installation

1. Install typesafe activator (0.3.18+)


## Definition of "meeting"
I'm assuming that both persons were within a distance of 3 meters in 1 minute time frame

## Bonuses
* Detecting time and location of meet
* No external database
* Use of functional language,(in fact only one shared state is the DataSource implementation)
* Modular and testable components

## Things I could improve
* Extract meeting definition and data source parameters into either command line arguments
* Remove noize, maybe some primitive clustering algo
* Add grouping by floors, and run the search in parallel on each floor
