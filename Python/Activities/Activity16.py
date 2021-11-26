class car:
    'This is car class'

    def __init__(self,Manufacturer,Model, make, transmission, color):
        self.Manufacturer = Manufacturer
        self.Model = Model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print (self.Manufacturer +" " + self.Model + " is moving")
    
    def stop(self):
        print (self.Manufacturer +" " +  self.Model + " has stopped")

obj1 = car("1990", "2021","2021","1900","Red")
obj2 = car("1992", "2020","2020","1902","White")
obj3 = car("1991", "2022","2022","1901","Black")

obj1.accelerate()
obj2.accelerate()
obj3.accelerate()

print("Stop function:")
obj1.stop()
obj2.stop()
obj3.stop()