db.createUser({
    user: "cmpe202",
    password: "cmpe202",
    roles: [
        {
            role: "readWrite",
            db: "cmpe202"

        }
    ]
})