local followthemodel = true
local model = Instance.new("Model", workspace)
local lib = loadstring(game:HttpGet("https://raw.githubusercontent.com/danyad22/jndfsnas/refs/heads/main/sup", true))();
local m = game.Players.LocalPlayer:GetMouse()
local togglerot = false
local down = false
local up = false
local r15 = false
local sprint = false
if game.Players.LocalPlayer.Character.Humanoid.RigType == Enum.HumanoidRigType.R15 then
	r15 = true
end
m.KeyDown:Connect(function(key)
	if string.byte(key) == 50 then
		sprint = true
	end
end)
m.KeyUp:Connect(function(key)
	if string.byte(key) == 50 then
		sprint = false
	end
end)
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
a4.Position = Vector3.new(0,5.46,0)
a.Rotation = Vector3.new(90,0,0)
a.Position = Vector3.new(-0.8,0.8,0)
a3.Position = Vector3.new(0,3.6,0)
a2.Position = Vector3.new(0,1.7,0)
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
a4.CanCollide = false
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
			if not sprint then
				model:PivotTo(model.WorldPivot + game.Players.LocalPlayer.Character.Humanoid.MoveDirection / 3)
			else
				model:PivotTo(model.WorldPivot + game.Players.LocalPlayer.Character.Humanoid.MoveDirection / 0.6)
			end
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
--	local lower = game.Players[target].Character.LowerTorso
--	game:GetService("RunService").PostSimulation:Connect(function()
--		a.CFrame = (lower.CFrame * CFrame.Angles(0,0,math.rad(90)) + Vector3.new(0,-.5,0)) + lower.CFrame.LookVector * 0.5
--	end)
--end)
for i,v in pairs(game.Players.LocalPlayer.Character:GetDescendants()) do
	if v:IsA("BasePart") then
		v.Massless = true
		v.CanQuery = false
		v.CanTouch = false
		v.CanCollide = false
	end
	if not r15 then
		if v.Name == "Left Leg" then --v.Name == "Right Leg"
			game:GetService("RunService").PostSimulation:Connect(function()
				v.CFrame = a.CFrame
				v.Velocity = Vector3.new(0,0.1,0)
				v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
				v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
			end)
		elseif v.Name == "Right Leg" then
			game:GetService("RunService").PostSimulation:Connect(function()
				v.CFrame = a2.CFrame * CFrame.Angles(math.rad(180), 0, 0)
				v.Velocity = Vector3.new(0,0.1,0)
				v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
				v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
			end)
		elseif v.Name == "Right Arm" then
			game:GetService("RunService").PostSimulation:Connect(function()
				v.CFrame = a4.CFrame * CFrame.Angles(math.rad(180), math.rad(-90), 0)
				v.Velocity = Vector3.new(0,0.1,0)
				v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
				v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
			end)
		elseif v.Name == "Left Arm" then
			game:GetService("RunService").PostSimulation:Connect(function()
				v.CFrame = a3.CFrame
				v.Velocity = Vector3.new(0,0.1,0)
				v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
				v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
			end)
		elseif v:IsA("BasePart") and (v.Name ~= "Left Leg" or v.Name ~= "Left Leg") then
			if not followthemodel then
				game:GetService("RunService").PostSimulation:Connect(function()
					v.CFrame = CFrame.new(Vector3.new(0,800,0)) * CFrame.Angles(math.rad(90),0,0)
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end)
			else
				game:GetService("RunService").PostSimulation:Connect(function()
					v.CFrame = a.CFrame + Vector3.new(0,1000,0)
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end)
			end
		end
	else
		if v.Name == "LeftLowerLeg" and v:IsA("BasePart") then
			spawn(function()
				while true do
					task.wait()
					v.CFrame = a.CFrame * CFrame.Angles(0,math.rad(16),0) + a.CFrame.UpVector * -0.1
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end
			end)

		elseif v.Name == "LeftUpperLeg" and v:IsA("BasePart") then
			spawn(function()
				while true do
					task.wait()
					v.CFrame = a.CFrame * CFrame.Angles(0,math.rad(16),0) + a.CFrame.UpVector * 0.5
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end
			end)

		--elseif v.Name == "LeftHand" and v:IsA("BasePart") then
		--	spawn(function()
		--		while true do
		--			task.wait()
		--			v.CFrame = a2.CFrame + a2.CFrame.UpVector * -0.7
		--			v.Velocity = Vector3.new(0,0,0)
		--			v.AssemblyLinearVelocity = Vector3.new(0,0,0)
		--			v.AssemblyAngularVelocity = Vector3.new(0,0,0)
		--		end
		--	end)

		elseif v.Name == "LeftLowerArm" and v:IsA("BasePart") then
			spawn(function()
				while true do
					task.wait()
					v.CFrame = a2.CFrame + a2.CFrame.UpVector * -0.1
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end
			end)

		elseif v.Name == "LeftUpperArm" and v:IsA("BasePart") then
			spawn(function()
				while true do
					task.wait()
					v.CFrame = a2.CFrame + a2.CFrame.UpVector * 0.5
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end
			end)

		--elseif v.Name == "RightHand" and v:IsA("BasePart") then
		--	spawn(function()
		--		while true do
		--			task.wait()
		--			v.CFrame = a3.CFrame + a3.CFrame.UpVector * -0.7
		--			v.Velocity = Vector3.new(0,0,0)
		--			v.AssemblyLinearVelocity = Vector3.new(0,0,0)
		--			v.AssemblyAngularVelocity = Vector3.new(0,0,0)
		--		end
		--	end)

		elseif v.Name == "RightLowerArm" and v:IsA("BasePart") then
			spawn(function()
				while true do
					task.wait()
					v.CFrame = a3.CFrame + a3.CFrame.UpVector * -0.1
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end
			end)

		elseif v.Name == "RightUpperArm" and v:IsA("BasePart") then
			spawn(function()
				while true do
					task.wait()
					v.CFrame = a3.CFrame + a3.CFrame.UpVector * 0.5
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end
			end)

		elseif v.Name == "RightFoot" and v:IsA("BasePart") then
			spawn(function()
				while true do
					task.wait()
					v.CFrame = a4.CFrame + a4.CFrame.UpVector * -0.7
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end
			end)

		elseif v.Name == "RightLowerLeg" and v:IsA("BasePart") then
			spawn(function()
				while true do
					task.wait()
					v.CFrame = a4.CFrame + a4.CFrame.UpVector * -0.1
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end
			end)

		elseif v.Name == "RightUpperLeg" and v:IsA("BasePart") then
			spawn(function()
				while true do
					task.wait()
					v.CFrame = a4.CFrame + a4.CFrame.UpVector * 0.5
					v.Velocity = Vector3.new(0,0.1,0)
					v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
					v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
				end
			end)
		else
			if v:IsA("BasePart") and v.Name ~= "Head" then
				if not followthemodel then
					spawn(function()
						while true do
							task.wait()
							v.CFrame = CFrame.new(Vector3.new(0,1000,0))
							v.Velocity = Vector3.new(0,0.1,0)
							v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
							v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
						end
					end)
				else
					spawn(function()
						while true do
							task.wait()
							v.CFrame = CFrame.new(a.Position) * CFrame.Angles(0,math.rad(a.Rotation.Y),0) + Vector3.new(0,1000,0)
							v.Velocity = Vector3.new(0,0.1,0)
							v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
							v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
						end
					end)
				end
			elseif v.Name == "Head" and v:IsA("BasePart") then
				spawn(function()
					while true do
						task.wait()
						v.CFrame = CFrame.new(a3.Position)
						v.Velocity = Vector3.new(0,0.1,0)
						v.AssemblyLinearVelocity = Vector3.new(0,0.1,0)
						v.AssemblyAngularVelocity = Vector3.new(0,0.1,0)
					end
				end)
			end
		end
	end
end
