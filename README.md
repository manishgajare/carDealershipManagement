# carDealershipManagement
Car Dealership Management

This is Java SE application focusing on 
- making profiles, customers and salespersons
- while making profiles of potential customers, storing their interests in vehicles
- placing order and generating invoices
- managing inventory when orders are placed and when quantity in inventory are updated with more available items (taking available inventory space into consideration)
- Giving recommendation (based on interests and previous orders) to the potential customers - by taking their age/income/gender into account

# Below mentianed classes are Sigleton Classes with Thread Safety: 
VehicleCatalog, 
InventoryCatalog, 
PersonDirectory, 
CustormerDirectory, 
SalesPersonDirectory, 
OrderCatalog, 
InvoiceCatalog

These classes are Singleton because we do not want to create their multiple instances. We want to create their instance at the  1st call and after that same instance should be utilized throughout the application.
They are made thread safe - incase there are multiple threads trying to get access at the same time, we want to let one of the thread to enter and create instance and lock the resource for the other till then, so that we do not create multiple instances.

# Inventory Management

We are setting up constants for total inventory spaces available with dealership for small/medium/large vehicles. Along with these, we are initailiazing available spaces with the total spaces when we are creating InventoryCatalog instance.

- Whenever we are adding new vehicle to inventory, available space is decremented and inventoryItem quantity is incremented.
- Whenever we are placing order or removing vehicles from inventory, available space is incremented and inventoryItem quantity is decremented.

# Recommendation of vehicles

Age, Gender and Income of potential customer is taken into account when giving recommendation

We check if person in PersonDirectory matches the profile of potential customer such that
- Age: Person's age lies in the range of +/-3 of potential customer's age
- Income: Person's income lies in the range of +/-15000 of potential customer's age
- Gender: Person's gender is same as potential customer's gender

If all criterias match, then we go through the interest of person in vehicles and previous purchases through OrderCatalog. We assign 10 points to the interests and 20 points to the purchases/orders and keep on adding them for the occurance of same vehicle interest/purchase which we come accross.

After we have list of vehicles associated with the points, we sort them according to points and put top 5 in separate list.

Separate list with 5 recommendations is sorted according to the price - which is shown to the sales person.

# Scope of Expansion for future
  - Create network: 
    We can create network such as, country -> state -> city -> zipcode for managing dealerships at various locations
  
  - Create logs: 
    We can create logs whenever anything is added to inventory or order is places
  
  - Give recommendation even if "all" criterias (age/income/gender) doesn't match: 
    It is possible that we do not have historic data which matches profile of potential customer. In this case we can give recommendations with relevancy score as per matches in criterias. The scores should be given to vehicles according to the below mentioned matches and in same order - since income is the most important factor when person goes to buy car.
    - income & age
    - income & gender
    - income
    - age & gender
    - age
    - gender

