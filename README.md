# cargo_distributor
Weight distribution of containers by weight into 3 bays with 4 tiers.


# Task

 * There is just the Container class given for this task.
 * There are 3 bays, each bay is split in 4 tiers
 * In every bay there can be put a max amount of 4 containers
 * Containers are distributed by descending weight: heaviest to lightest
 * A Container will be distributed into the Bay with the lowest total weight
 * The first container will be put into Bay 1
 * If they Bays are all filled, or no Containers are available, the distribution will be stopped.
