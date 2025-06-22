INSERT INTO vehicles 
(license_plate, model, capacity, active, created_by, updated_by)
VALUES 
('ABC-123', 'Toyota Hiace', 15, TRUE, 'admin', 'admin'),
('XYZ-789', 'Mercedes Sprinter', 20, TRUE, 'admin', 'admin');

INSERT INTO route_vehicle_assignments 
(route_id, schedule_id, vehicle_id, assignment_date, created_by, updated_by)
VALUES 
(101, 1001, 1, '2025-06-01', 'admin', 'admin'),
(102, 1002, 2, '2025-06-02', 'admin', 'admin');
