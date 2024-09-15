 
from collections import defaultdict

# names of hurricanes
names = ['Cuba I', 'San Felipe II Okeechobee', 'Bahamas', 'Cuba II', 'CubaBrownsville', 'Tampico', 'Labor Day', 'New England', 'Carol', 'Janet', 'Carla', 'Hattie', 'Beulah', 'Camille', 'Edith', 'Anita', 'David', 'Allen', 'Gilbert', 'Hugo', 'Andrew', 'Mitch', 'Isabel', 'Ivan', 'Emily', 'Katrina', 'Rita', 'Wilma', 'Dean', 'Felix', 'Matthew', 'Irma', 'Maria', 'Michael']

# months of hurricanes
months = ['October', 'September', 'September', 'November', 'August', 'September', 'September', 'September', 'September', 'September', 'September', 'October', 'September', 'August', 'September', 'September', 'August', 'August', 'September', 'September', 'August', 'October', 'September', 'September', 'July', 'August', 'September', 'October', 'August', 'September', 'October', 'September', 'September', 'October']

# years of hurricanes
years = [1924, 1928, 1932, 1932, 1933, 1933, 1935, 1938, 1953, 1955, 1961, 1961, 1967, 1969, 1971, 1977, 1979, 1980, 1988, 1989, 1992, 1998, 2003, 2004, 2005, 2005, 2005, 2005, 2007, 2007, 2016, 2017, 2017, 2018]

# maximum sustained winds (mph) of hurricanes
max_sustained_winds = [165, 160, 160, 175, 160, 160, 185, 160, 160, 175, 175, 160, 160, 175, 160, 175, 175, 190, 185, 160, 175, 180, 165, 165, 160, 175, 180, 185, 175, 175, 165, 180, 175, 160]

# areas affected by each hurricane
areas_affected = [['Central America', 'Mexico', 'Cuba', 'Florida', 'The Bahamas'], ['Lesser Antilles', 'The Bahamas', 'United States East Coast', 'Atlantic Canada'], ['The Bahamas', 'Northeastern United States'], ['Lesser Antilles', 'Jamaica', 'Cayman Islands', 'Cuba', 'The Bahamas', 'Bermuda'], ['The Bahamas', 'Cuba', 'Florida', 'Texas', 'Tamaulipas'], ['Jamaica', 'Yucatn Peninsula'], ['The Bahamas', 'Florida', 'Georgia', 'The Carolinas', 'Virginia'], ['Southeastern United States', 'Northeastern United States', 'Southwestern Quebec'], ['Bermuda', 'New England', 'Atlantic Canada'], ['Lesser Antilles', 'Central America'], ['Texas', 'Louisiana', 'Midwestern United States'], ['Central America'], ['The Caribbean', 'Mexico', 'Texas'], ['Cuba', 'United States Gulf Coast'], ['The Caribbean', 'Central America', 'Mexico', 'United States Gulf Coast'], ['Mexico'], ['The Caribbean', 'United States East coast'], ['The Caribbean', 'Yucatn Peninsula', 'Mexico', 'South Texas'], ['Jamaica', 'Venezuela', 'Central America', 'Hispaniola', 'Mexico'], ['The Caribbean', 'United States East Coast'], ['The Bahamas', 'Florida', 'United States Gulf Coast'], ['Central America', 'Yucatn Peninsula', 'South Florida'], ['Greater Antilles', 'Bahamas', 'Eastern United States', 'Ontario'], ['The Caribbean', 'Venezuela', 'United States Gulf Coast'], ['Windward Islands', 'Jamaica', 'Mexico', 'Texas'], ['Bahamas', 'United States Gulf Coast'], ['Cuba', 'United States Gulf Coast'], ['Greater Antilles', 'Central America', 'Florida'], ['The Caribbean', 'Central America'], ['Nicaragua', 'Honduras'], ['Antilles', 'Venezuela', 'Colombia', 'United States East Coast', 'Atlantic Canada'], ['Cape Verde', 'The Caribbean', 'British Virgin Islands', 'U.S. Virgin Islands', 'Cuba', 'Florida'], ['Lesser Antilles', 'Virgin Islands', 'Puerto Rico', 'Dominican Republic', 'Turks and Caicos Islands'], ['Central America', 'United States Gulf Coast (especially Florida Panhandle)']]

# damages (USD($)) of hurricanes
damages = ['Damages not recorded', '100M', 'Damages not recorded', '40M', '27.9M', '5M', 'Damages not recorded', '306M', '2M', '65.8M', '326M', '60.3M', '208M', '1.42B', '25.4M', 'Damages not recorded', '1.54B', '1.24B', '7.1B', '10B', '26.5B', '6.2B', '5.37B', '23.3B', '1.01B', '125B', '12B', '29.4B', '1.76B', '720M', '15.1B', '64.8B', '91.6B', '25.1B']

# deaths for each hurricane
deaths = [90,4000,16,3103,179,184,408,682,5,1023,43,319,688,259,37,11,2068,269,318,107,65,19325,51,124,17,1836,125,87,45,133,603,138,3057,74]

# 1
# Update Recorded Damages
conversion = {"M": 1000000,
              "B": 1000000000}

# test function by updating damages
# Cleaned list to store updated damage values
updated_damages = []

for damage in damages:
    if damage == 'Damages not recorded':
        updated_damages.append(damage)
    elif "M" in damage:
        updated_damages.append(float(damage.replace("M", "")) * conversion["M"])
    elif "B" in damage:
        updated_damages.append(float(damage.replace("B", "")) * conversion["B"])
damages = updated_damages
#print(damages)

#2
# Create a Table
hurricanes = {}
# Create and view the hurricanes dictionary
for i in range(len(names)):
    hurricanes[names[i]] = {"Name": names[i], "Month": months[i], "Year":years[i], "max_sustained_winds": max_sustained_winds[i], "areas_affected": areas_affected[i], "damages": damages[i], "deaths": deaths[i]}
#print(hurricanes)

# 3
# Organizing by Year
hurricane_by_year = defaultdict(list)
# create a new dictionary of hurricanes with year and key
for i in range(len(years)):
  hurricane_data = {"Name": names[i], "Month": months[i], "Year":years[i], "max_sustained_winds": max_sustained_winds[i], "areas_affected": areas_affected[i], "damages": damages[i], "deaths": deaths[i]}
  hurricane_by_year[years[i]].append(hurricane_data)
#print(hurricane_by_year)
# 4
# Counting Damaged Areas
damaged_areas = defaultdict(int)
# create dictionary of areas to store the number of hurricanes involved in
for area in areas_affected:
   for local in area:
      damaged_areas[local] += 1
damaged_areas = dict(damaged_areas)
#print(damaged_areas)

# 5 
# Calculating Maximum Hurricane Count
max_count = 0
max_local = None
# find most frequently affected area and the number of hurricanes involved in
for key, value in damaged_areas.items():
  if value > max_count:
    max_count = value
    max_local = key
#print(str(max_local) + ": " + str(max_count))


# 6
# Calculating the Deadliest Hurricane
max_death = 0
max_local = None
# find highest mortality hurricane and the number of deaths
for hurricane in hurricanes.values():
    deaths = hurricane["deaths"]
    if deaths > max_death:
        max_death = deaths
        max_local = hurricane
#print(f"{max_local['Name']}: {max_death}")

# 7
# Rating Hurricanes by Mortality
hurricanes_by_mortality = defaultdict(list)

# Categorize hurricanes based on severity of deaths
for hurricane in hurricanes.values():
    name = hurricane["Name"]
    deaths = hurricane["deaths"]
    
    if deaths >= 10000:
        hurricanes_by_mortality[4].append(name)  # Categoria 4: mortalidade extrema
    elif deaths >= 1000:
        hurricanes_by_mortality[3].append(name)  # Categoria 3: mortalidade muito alta
    elif deaths >= 500:
        hurricanes_by_mortality[2].append(name)  # Categoria 2: mortalidade alta
    elif deaths >= 100:
        hurricanes_by_mortality[1].append(name)  # Categoria 1: mortalidade moderada
    else:
        hurricanes_by_mortality[0].append(name)  # Categoria 0: mortalidade baixa

# Classificar os furacões por mortalidade em ordem crescente
for severity in sorted(hurricanes_by_mortality.keys()):
#print(f"Categoria {severity}: {hurricanes_by_mortality[severity]}")

# 8 Calculating Hurricane Maximum Damage
  max_cost = 0
  max_local = None
# find highest damage inducing hurricane and its total cost
for hurricane in hurricane_by_year.values():
    for single_hurricane in hurricane:
      damage = single_hurricane["damages"]
      name = single_hurricane["Name"]
    if damage == "Damages not recorded":
        continue
    if int(damage) > max_cost:
        max_cost = int(damage)
        max_local = name
        
#print(f"{max_local}: {max_cost}")

# 9
# Rating Hurricanes by Damage
damage_scale = {0: 0,
                1: 100000000,
                2: 1000000000,
                3: 10000000000,
                4: 50000000000}
  
# categorize hurricanes in new dictionary with damage severity as key
hurricanes_by_damage = defaultdict(list)

for hurricane in hurricanes.values():
    name = hurricane["Name"]
    cost = hurricane["damages"]
    if cost == "Damages not recorded":
        continue
    if cost >= 50000000000:
        hurricanes_by_damage[4].append(name)  # Categoria 4: damage extrema
    elif cost >= 10000000000:
        hurricanes_by_damage[3].append(name)  # Categoria 3: damage  muito alta
    elif cost >= 1000000000:
        hurricanes_by_damage[2].append(name)  # Categoria 2: damage alta
    elif cost >= 100000000:
        hurricanes_by_damage[1].append(name)  # Categoria 1: damage moderada
    else:
        hurricanes_by_damage[0].append(name)  # Categoria 0: mortalidade baixa

for costly in sorted(hurricanes_by_damage.keys()):
#print(f"Categoria {costly}: {hurricanes_by_damage[costly]}")
