db.people.aggregate([
  { $group: { _id: "$sex", avg_w: { $avg: "$weight"}, avg_h: { $avg: "$height"} } }
])