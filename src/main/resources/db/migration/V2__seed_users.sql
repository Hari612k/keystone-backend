INSERT INTO users
(full_name, email, password, phone, role, enabled, created_at, updated_at)
VALUES
(
'Dana Dispatcher',
'dispatcher@keystone.com',
'$2b$12$mmoZyYAJsTUXb4wQDOAeeeuFIWePBp1lv3Bw7EltF1NB2GxxMKPx6',
'9999999991',
'DISPATCHER',
true,
NOW(),
NOW()
),
(
'Tom Technician',
'technician@keystone.com',
'$2b$12$.QK2GBJwBWY8otWI8J23ROFxoZhhP8rpj9r1vuys6Vsp9jy62SieC',
'9999999992',
'TECHNICIAN',
true,
NOW(),
NOW()
),
(
'Mona Manager',
'manager@keystone.com',
'$2b$12$cnukhq4DscascVdvhc78eOLzzqSz5vJKj.alJdpKxaa9B19jKE2oe',
'9999999993',
'MANAGER',
true,
NOW(),
NOW()
),
(
'Casey Customer',
'customer@keystone.com',
'$2b$12$ZT6YTIhcT9oc3AXPvcM0N.FsbFxdeVWcLGAGzyJGOnL.dKIsxt0Em',
'9999999994',
'CUSTOMER',
true,
NOW(),
NOW()
);