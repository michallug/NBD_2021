s17190

1.1. 
MATCH (t:town {name: "Darjeeling"}), (p:peak {name: "Sandakphu"})
MATCH path = ShortestPath((t)-[*]->(p))
RETURN path

1.2. 
MATCH (t:town {name: "Darjeeling"}), (p:peak {name: "Sandakphu"})
MATCH path = ShortestPath((t)-[*]->(p))
WHERE ALL (r IN relationships(path) WHERE r.winter = "true")
RETURN path

1.3.
MATCH path = (t:town {name: "Darjeeling"})-[r*]->(p:peak {name: "Sandakphu"})
UNWIND r as rl //lista do oddzielnych wierszy
WITH path, COLLECT(rl.distance) AS distances
WITH path, REDUCE(acc = 0, d in distances | acc + d) as distance //reduce(accumulator = initial, variable IN list | expression)
RETURN path, distance
ORDER BY distance ASC

MATCH path = (t:town {name: "Darjeeling"})-[r:twowheeler*]->(dest)
WHERE ALL (r IN relationships(path) WHERE r.summer = "true")
RETURN dest //brak wyników

/*
MATCH path = (t:town {name: "Rimbik"})-[r:twowheeler*]->(dest)
WHERE ALL (r IN relationships(path) WHERE r.summer = "true")
RETURN dest
*/

2.4
MATCH (a:Airport)<-[:ORIGIN*]-(f:Flight)
WITH a, COUNT(f) AS count_f
RETURN a, count_f
ORDER BY count_f DESC

2.5
MATCH path = (a:Airport {name:"LAX"})<-[:ORIGIN]-(f:Flight)-[:DESTINATION]->(dest:Airport)
WHERE REDUCE(acc = 0, n IN [x IN NODES(path) WHERE 'Flight' IN LABELS(x)] |
				(acc + [(n)<-[:ASSIGN]-(Ticket) | Ticket.price][0])
			) < 3000
RETURN path

2.6
MATCH path = (a:Airport {name:"LAX"})<-[:ORIGIN]-(:Flight)-[:DESTINATION]->(dest:Airport {name: "DAY"})
WITH path, REDUCE(acc = 0, n IN [x IN NODES(path) WHERE 'Flight' IN LABELS(x)] |
					acc + [(n)<-[:ASSIGN]-(Ticket) | Ticket.price][0]
				 ) as sum
RETURN path, sum
ORDER BY sum asc //brak wyników - DAY nie ma żadnych węzłów

2.7
MATCH path = (a:Airport {name:"LAX" })<-[:ORIGIN]-(:Flight)-[:DESTINATION]->(dest:Airport {name: "DAY"})
WITH path, REDUCE(acc = 0, n IN [x IN NODES(path) WHERE 'Flight' IN LABELS(x)] |
					acc + [(n)<-[:ASSIGN]-(Ticket) | Ticket.price][0]
				 ) as sum
RETURN path, sum
ORDER BY sum asc 
LIMIT 1 //brak wyników

2.8
MATCH path = (a:Airport {name:"LAX" })<-[:ORIGIN]-(:Flight)-[:DESTINATION]->(dest:Airport {name: "DAY"})
WITH path, REDUCE(acc = 0, n IN [x IN NODES(path) WHERE 'Flight' IN LABELS(x)] |
					acc + [(n)<-[:ASSIGN]-(Ticket {class: 'business'}) | Ticket.price][0]
				 ) as sum
RETURN path, sum
ORDER BY sum asc 
LIMIT 1 //brak wyników

2.9
MATCH (a:Airport)<-[:ORIGIN]-(f:Flight)-[:DESTINATION]->(dest:Airport)
WITH [a.name, dest.name, f.airline] AS connection, f
RETURN f.airline AS airline, COUNT(DISTINCT connection) AS connections
ORDER BY connections desc 

2.10
MATCH path = (a1:Airport)<-[:ORIGIN]-(:Flight)-[:DESTINATION]->(a2:Airport)<-[r3:ORIGIN]-(:Flight)-[:DESTINATION]->(a3:Airport)
WHERE a1<>a2 AND a1<>a3 AND a2<>a3
WITH path, REDUCE(acc = 0, n IN [x IN NODES(path) WHERE 'Flight' IN LABELS(x)] |
					acc + [(n)<-[:ASSIGN]-(Ticket {class: 'economy'}) | Ticket.price][0]
				 ) as sum
RETURN path, sum
ORDER BY sum asc
LIMIT 1
