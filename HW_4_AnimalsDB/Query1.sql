select animals.species, animals.animal_name, shelters.shelter_name, shelters.location
from animals inner join shelters on animals.shelter_id = shelters.shelter_id;