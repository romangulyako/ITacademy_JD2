select shelters.shelter_name, shelters.location,animals.species, animals.animal_name
from animals right join shelters on animals.shelter_id = shelters.shelter_id;