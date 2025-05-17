local model = Instance.new("Model", workspace)
local m = game.Players.LocalPlayer:GetMouse()
local togglerot = false
local down = false
local up = false
--local target = "danitop3322"
m.KeyDown:Connect(function(key)
	if key == "z" then
		up = true
	end
	if key == "x" then
		down = true
	end
end)
m.KeyUp:Connect(function(key)
	if key == "z" then
		up = false
	end
	if key == "x" then
		down = false
	end
end)
local a = Instance.new("Part", model)
a.Size = Vector3.new(1.1,2.1,1.1)
local a2 = Instance.new("Part", model)
a2.Size = Vector3.new(1.1,2.1,1.1)
local a3 = Instance.new("Part", model)
a3.Size = Vector3.new(1.1,2.1,1.1)
local a4 = Instance.new("Part", model)
a4.Size = Vector3.new(1.1,2.1,1.1)
a4.Position = Vector3.new(0,5,0)
a.Anchored = true
a.Rotation = Vector3.new(90,0,0)
a.Position = Vector3.new(-0.5,0.5,0)
a3.Position = Vector3.new(0,3.15,0)
a2.Position = Vector3.new(0,1.3,0)
a.CanQuery = false
a2.CanQuery = false
a3.CanQuery = false
a4.CanQuery = false
a.Transparency = 0.6
a2.Transparency = 0.6
a3.Transparency = 0.6
a4.Transparency = 0.6
a.Anchored = true
a.CanCollide = false
a2.CanCollide = false
a3.CanCollide = false
a4.CanCollide= false
game.Players.LocalPlayer.Character.Humanoid.Died:Connect(function()
	model:Destroy()
end)
spawn(function()
	local last = nil
	for i,v in pairs(model:GetChildren()) do
		if last == nil then
			last = v
		else
			local a = Instance.new("WeldConstraint", model)
			a.Part0 = last
			a.Part1 = v
			last = v
		end
	end
end)
spawn(function()
	while true do
		task.wait()
		workspace.CurrentCamera.CameraSubject = model
	end
end)
model:MoveTo(game.Players.LocalPlayer.Character.HumanoidRootPart.Position)
spawn(function()
	while true do
		task.wait()
		if not togglerot then
			model:PivotTo(model.WorldPivot + game.Players.LocalPlayer.Character.Humanoid.MoveDirection / 3)
			a.CFrame = CFrame.new(a.Position, a.Position + Vector3.new(workspace.CurrentCamera.CFrame.LookVector.X,a.Position,workspace.CurrentCamera.CFrame.LookVector.Z)) * CFrame.Angles(0,0,math.rad(90))	
		end
		if up then
			model:PivotTo(model.WorldPivot + Vector3.new(0,0.2,0))
		end
		if down then
			model:PivotTo(model.WorldPivot + Vector3.new(0,-0.2,0))
		end
	end
end)
--spawn(function()
--	game:GetService("RunService").PostSimulation:Connect(function()
--		a.CFrame = (game.Players[target].Character.HumanoidRootPart.CFrame * CFrame.Angles(0,0,math.rad(90))) + Vector3.new(0, -1.5, 0) + game.Players[target].Character.HumanoidRootPart.CFrame.LookVector 
--	end)
--end)
for i,v in pairs(game.Players.LocalPlayer.Character:GetDescendants()) do
	if v.Name == "Left Leg" then --v.Name == "Right Leg"
		game:GetService("RunService").PostSimulation:Connect(function()
			v.CFrame = a.CFrame
			v.Velocity = Vector3.new(0,1,0)
			v.AssemblyLinearVelocity = Vector3.new(0,1,0)
			v.AssemblyAngularVelocity = Vector3.new(0,0,0)
		end)
	elseif v.Name == "Right Leg" then
		game:GetService("RunService").PostSimulation:Connect(function()
			v.CFrame = a2.CFrame * CFrame.Angles(math.rad(180), 0, 0)
			v.Velocity = Vector3.new(0,1,0)
			v.AssemblyLinearVelocity = Vector3.new(0,1,0)
			v.AssemblyAngularVelocity = Vector3.new(0,0,0)
		end)
	elseif v.Name == "Right Arm" then
		game:GetService("RunService").PostSimulation:Connect(function()
			v.CFrame = a4.CFrame * CFrame.Angles(math.rad(180), math.rad(-90), 0)
			v.Velocity = Vector3.new(0,1,0)
			v.AssemblyLinearVelocity = Vector3.new(0,1,0)
			v.AssemblyAngularVelocity = Vector3.new(0,0,0)
		end)
	elseif v.Name == "Left Arm" then
		game:GetService("RunService").PostSimulation:Connect(function()
			v.CFrame = a3.CFrame
			v.Velocity = Vector3.new(0,1,0)
			v.AssemblyLinearVelocity = Vector3.new(0,1,0)
			v.AssemblyAngularVelocity = Vector3.new(0,0,0)
		end)
	elseif v:IsA("BasePart") and (v.Name ~= "Left Leg" or v.Name ~= "Left Leg") then
		game:GetService("RunService").PostSimulation:Connect(function()
			v.CFrame = CFrame.new(model.WorldPivot.Position + Vector3.new(0,600,0))
			v.Velocity = Vector3.new(0,0.05,0)
			v.AssemblyLinearVelocity = Vector3.new(0,0.05,0)
			v.AssemblyAngularVelocity = Vector3.new(0,0,0)
		end)
	end
end
