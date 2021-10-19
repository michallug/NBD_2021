s17190

1. MATCH (m:Movie) RETURN m
2. MATCH (p:Person {name: "Hugo Weaving"})-[:ACTED_IN]->(m) RETURN p, m
3. MATCH (p:Person {name: "Hugo Weaving"})-[:ACTED_IN]->(m)<-[:DIRECTED]-(d) RETURN d
4. MATCH (p:Person {name: "Hugo Weaving"})-[:ACTED_IN]->(m)<-[:ACTED_IN]-(p2) RETURN p2
5. MATCH (mx:Movie {title: "The Matrix"})-[:ACTED_IN]-(p)-[:ACTED_IN]-(m) RETURN m
6. MATCH (p:Person)-[:ACTED_IN]-(m) WITH p, count(m) as mCnt WHERE cnt > 0 RETURN p, mCnt
7. MATCH (p:Person)-[:WROTE]-(m:Movie) WHERE (p)-[:DIRECTED]-(m) RETURN p, m
8. MATCH (p:Person {name: "Hugo Weaving"})-[:ACTED_IN]-(m)-[:ACTED_IN]-(p2:Person {name: "Keanu Reeves"}) RETURN m
9. 
CREATE (n:Movie {
	released: 2011, 
	tagline: "Steve Rogers, a rejected military soldier, transforms into Captain America after taking a dose of a Super-Soldier serum. But being Captain America comes at a price as he attempts to take down a war monger and a terrorist organization.", 
	title: "Captain America: The First Avenger"}
)

CREATE (p:Person {name: "Joe Johnston", born: 1950})
MATCH (p:Person), (m:Movie) WHERE p.name = "Joe Johnston" AND m.title = "Captain America: The First Avenger" CREATE (p)-[:DIRECTED]->(m)

CREATE (p:Person {name: "Christopher Markus", born: 1970})
MATCH (p:Person), (m:Movie) WHERE p.name = "Christopher Markus" AND m.title = "Captain America: The First Avenger" CREATE (p)-[:WROTE]->(m)

CREATE (n:Person {name: "Stephen McFeely", born: 1969})
MATCH (p:Person), (m:Movie) WHERE p.name = "Stephen McFeely" AND m.title = "Captain America: The First Avenger" CREATE (p)-[:WROTE]->(m)

CREATE (n:Person {name: "Joe Simon", born: 1913})
MATCH (p:Person), (m:Movie) WHERE p.name = "Joe Simon" AND m.title = "Captain America: The First Avenger" CREATE (p)-[:WROTE]->(m)

CREATE (p:Person {name: "Chris Evans", born: 1981})
MATCH (p:Person), (m:Movie) WHERE p.name = "Chris Evans" AND m.title = "Captain America: The First Avenger" CREATE (p)-[:ACTED_IN]->(m)

CREATE (p:Person {name: "Hayley Atwell", born: 1982})
MATCH (p:Person), (m:Movie) WHERE p.name = "Hayley Atwell" AND m.title = "Captain America: The First Avenger" CREATE (p)-[:ACTED_IN]->(m)

CREATE (p:Person {name: "Samuel L. Jackson", born: 1948})
MATCH (p:Person), (m:Movie) WHERE p.name = "Samuel L. Jackson" AND m.title = "Captain America: The First Avenger" CREATE (p)-[:ACTED_IN]->(m)

MATCH (m:Movie {title: 'Captain America: The First Avenger'})-[t:ACTED_IN|DIRECTED|WROTE]-(p) RETURN m, p, type(t)