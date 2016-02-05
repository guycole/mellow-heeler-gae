import webapp2

from google.appengine.ext import db
from google.appengine.api import memcache


class GeographicLocation(db.Model):
    accuracy = db.FloatProperty()
    altitude = db.FloatProperty()
    installationUuid = db.StringProperty()
    location = db.GeoPtProperty()
    locationUuid = db.StringProperty()
    sortieUuid = db.StringProperty()
    specialFlag = db.BooleanProperty()
    timeStamp = db.DateTimeProperty()

class Observation(db.Model):
    bssid = db.StringProperty()
    capability = db.StringProperty()
    frequency = db.IntegerProperty()
    installationUuid = db.StringProperty()
    locationUuid = db.StringProperty()
    observationUuid = db.StringProperty()
    sortieUuid = db.StringProperty()
    ssid = db.StringProperty()
    strength = db.IntegerProperty()
    timeStamp = db.DateTimeProperty()

class Sortie(db.Model):
    installationUuid = db.StringProperty()
    name = db.StringProperty()
    note = db.StringProperty()
    sortieUuid = db.StringProperty()
    timeStamp = db.DateTimeProperty()

class MainPage(webapp2.RequestHandler):
    def get(self):
        self.response.headers['Content-Type'] = 'text/plain'
        self.response.write('Mellow Heeler Migration Tool')

class LocationDump(webapp2.RequestHandler):
    def get(self):
        self.response.headers['Content-Type'] = 'text/plain'

        locationz = GeographicLocation.all()

        cursor_name = 'loc_cursor1c'

        cursor = memcache.get(cursor_name)
        if cursor:
            locationz.with_cursor(start_cursor=cursor)

        locationz.order("-timeStamp")
        for location in locationz.run(limit=10000):
            self.response.write("%f," % location.accuracy)
            self.response.write("%f," % location.altitude)
            self.response.write("%s," % location.installationUuid)
            self.response.write("%f:%f," % (location.location.lat, location.location.lon))
            self.response.write("%s," % location.locationUuid)
            self.response.write("%s," % location.sortieUuid)
# specialFlag
            self.response.write("%s\n" % location.timeStamp)

        cursor = locationz.cursor()
        memcache.set(cursor_name, cursor)

class ObservationDump(webapp2.RequestHandler):
    def get(self):
        self.response.headers['Content-Type'] = 'text/plain'

        observationz = Observation.all()

        cursor_name = 'obs_cursor1c'

        cursor = memcache.get(cursor_name)
        if cursor:
            observationz.with_cursor(start_cursor=cursor)

        observationz.order("-timeStamp")
        for observation in observationz.run(limit=10000):
            self.response.write("%s," % observation.bssid)
            self.response.write("%s," % observation.capability)
            self.response.write("%d," % observation.frequency)
            self.response.write("%s," % observation.installationUuid)
            self.response.write("%s," % observation.observationUuid)
            self.response.write("%s," % observation.locationUuid)
            self.response.write("%s," % observation.sortieUuid)
            self.response.write("%d," % observation.strength)
            self.response.write("%s," % observation.ssid)
            self.response.write("%s\n" % observation.timeStamp)

        cursor = observationz.cursor()
        memcache.set(cursor_name, cursor)


class SortieDump(webapp2.RequestHandler):
    def get(self):
        self.response.headers['Content-Type'] = 'text/plain'
#        self.response.write('<html><body>')
#        self.response.write('SortieStub')

#        sortie_query = Sortie.query().order(-Sortie.timeStamp)
#        sortiez = sortie_query.fetch()

        query = Sortie.all()
#        query.order(-Sortie.timeStamp)

#        self.response.write('-x-x-x-start-x-x-x-x<br>')
        for sortie in query:
            self.response.write("%s," % sortie.installationUuid)
            self.response.write("%s," % sortie.name)
            self.response.write("%s," % sortie.note)
            self.response.write("%s," % sortie.sortieUuid)
            self.response.write("%s\n" % sortie.timeStamp)

#        self.response.write('-x-x-x-stop-x-x-x-x<p>')
#        self.response.write(len(sortiez))
#        self.response.write('<br></body></html>')

app = webapp2.WSGIApplication([
        ('/', MainPage),
        ('/location', LocationDump),
        ('/observation', ObservationDump),
        ('/sortie', SortieDump),
    ], debug=True)
